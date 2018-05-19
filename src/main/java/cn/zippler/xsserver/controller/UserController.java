package cn.zippler.xsserver.controller;

import cn.zippler.xsserver.dao.UserDao;
import cn.zippler.xsserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @PostMapping(path = "/save",produces = "application/json",consumes = "application/json")
    public User save(@RequestBody User temp){
        return userDao.save(temp);//PostMapping->RequestBody
    }

    @RequestMapping("/list")
    public List<User> all(){
        return userDao.findAll();
    }
}
