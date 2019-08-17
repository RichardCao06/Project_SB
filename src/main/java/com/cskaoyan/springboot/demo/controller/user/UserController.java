package com.cskaoyan.springboot.demo.controller.user;


import com.cskaoyan.springboot.demo.bean.Errno;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.User;
import com.cskaoyan.springboot.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public Object list(int page,int limit,String username,String mobile,String sort,String order){
        PageBean<User> users = userService.findByCondition(page, limit,username,mobile,sort,order);
        return new Errno(users,"成功",0);
    }
}
