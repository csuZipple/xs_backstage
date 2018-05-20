package cn.zippler.xsserver.controller;

import cn.zippler.xsserver.dao.CommentDao;
import cn.zippler.xsserver.dao.UserDao;
import cn.zippler.xsserver.dao.VideoDao;
import cn.zippler.xsserver.entity.Comment;
import cn.zippler.xsserver.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private UserDao userDao;
    private CommentDao commentDao;
    private VideoDao videoDao;

    @Autowired
    public CommentController(UserDao userDao, CommentDao commentDao, VideoDao videoDao) {
        this.userDao = userDao;
        this.commentDao = commentDao;
        this.videoDao = videoDao;
    }

    @PostMapping("/add")
    public Comment add(@RequestParam("userId")Long userId, @RequestParam("videoId")Long videoId, @RequestParam("content")String content){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(userDao.getOne(userId));//userId must be exist and so do videoId
        comment.setVideo(videoDao.getOne(videoId));
        return commentDao.save(comment);
    }
}
