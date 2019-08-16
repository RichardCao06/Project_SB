package com.cskaoyan.springboot.demo.controller.user;

import com.cskaoyan.springboot.demo.been.Errno;
import com.cskaoyan.springboot.demo.been.PageBean;
import com.cskaoyan.springboot.demo.been.User;
import com.cskaoyan.springboot.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public Object list(int page,int limit,String username,String mobile,String sort,String order){
        PageBean<User> users;
        users = userService.findByCondition(page, limit,username,mobile);
        return new Errno(users,"成功",0);
    }
}
