package cn.zippler.xsserver.controller;

import cn.zippler.xsserver.dao.UserDao;
import cn.zippler.xsserver.dao.VideoDao;
import cn.zippler.xsserver.entity.User;
import cn.zippler.xsserver.entity.Video;
import cn.zippler.xsserver.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoController {

    private VideoDao videoDao;
    private UserDao userDao;
    private ResourceLoader resourceLoader;

    @Autowired
    public VideoController(VideoDao videoDao, UserDao userDao, ResourceLoader resourceLoader) {
        this.videoDao = videoDao;
        this.userDao = userDao;
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/upload")
    public Map<String,Object> upload(@RequestParam("file")MultipartFile file, @RequestParam Long userId,@RequestParam String desc){
        Map<String,Object> result = new HashMap<>();
        String filename = file.getOriginalFilename();
        String path = FileUtil.getVideoPath()+"/"+filename;
        if (!file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).equals("mp4")){
            if (!file.isEmpty()) {
                try {
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path)));
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                    //更新user和video
                    Video video = new Video();
                    video.setDeployer(userDao.getOne(userId));//userId must not be null.
                    video.setUrl(filename);
                    //set poster.maybe not
                    video.setDescription(desc);
                    videoDao.save(video);
                    result.put("status","1");
                    result.put("info","上传成功");

                } catch (IOException e) {
                    result.put("status","0");
                    result.put("info","文件存储失败");
                    e.printStackTrace();
                }
            } else {
                result.put("status","0");
                result.put("info","后台未接收到视频文件");
            }
        }else {
            result.put("status","0");
            result.put("info","请上传mp4格式的视频");
        }
        return result;
    }

    @RequestMapping("/list")
    public List<Video> list(){
        return videoDao.findAll();
    }

    @RequestMapping("/page")
    public Page<Video> page(int page, int size){
        return videoDao.findAll(new PageRequest(page, size));
    }

    @RequestMapping("/sort")
    public List<Video> sort() {
        return videoDao.findAll(new Sort(Sort.Direction.ASC, "likes"));
    }
    @PostMapping("/update")
    public Video update(@RequestBody Video temp){
        videoDao.saveAndFlush(temp);
        return temp;
    }

    @RequestMapping(value = "/file/{filename}")
    @ResponseBody
    public ResponseEntity<?> preview(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get("./video/", filename).toString()));//为什么在浏览器上输出的是二进制?
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //get url.

    @RequestMapping(value = "/download/{filename}")
    @ResponseBody
    public void download(@PathVariable String filename,HttpServletResponse res) {
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + filename);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os ;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("./video/"
                    + filename)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping("/deployer")
    public List<Video> findVideoByDeployer(@RequestParam("userId")Long userId){
        return videoDao.findVideosByDeployer(userDao.getOne(userId));
    }

}
