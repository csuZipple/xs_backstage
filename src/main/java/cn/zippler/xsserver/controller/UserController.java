package cn.zippler.xsserver.controller;

import cn.zippler.xsserver.dao.UserDao;
import cn.zippler.xsserver.entity.User;
import cn.zippler.xsserver.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private  UserDao userdao;

    @Autowired
    public UserController(UserDao userdao) {
        this.userdao = userdao;
    }

    @PostMapping(path = "/save",produces = "application/json",consumes = "application/json")
    public User register(@RequestBody User user){
        return userdao.save(user);
    }

    @RequestMapping("/list")
    public List<User> list(){
        System.out.println("load user list");
        return userdao.findAll();
    }

    //查看收藏的视频和发布的视频
}
