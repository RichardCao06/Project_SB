package com.cskaoyan.springboot.demo.controller;

import com.cskaoyan.springboot.demo.been.Data;
import com.cskaoyan.springboot.demo.been.Info;
import com.cskaoyan.springboot.demo.been.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {


    @RequestMapping("auth/login")
    @ResponseBody
    public Message login(){
        Message message = new Message();
        message.setErrno(0);
        message.setData("7a92419d-0e29-4c1a-9a3f-b5b890cb8a38");
        message.setErrmsg("成功");
        return message;
    }

    @RequestMapping("auth/info")
    @ResponseBody
    public Info info(){
        Info info = new Info();
        info.setErrno(0);
        info.setErrmsg("成功");
        Data data = new Data();
        data.setName("admin123");
        data.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        List<String> perms = new ArrayList<>();
        perms.add("*");
        List<String> roles = new ArrayList<>();
        roles.add("超级管理员");
        data.setPerms(perms);
        data.setRoles(roles);
        info.setData(data);
        System.out.println(info);
        return info;

    }

}
