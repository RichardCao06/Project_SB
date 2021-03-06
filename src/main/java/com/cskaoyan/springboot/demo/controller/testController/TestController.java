package com.cskaoyan.springboot.demo.controller.testController;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.systembean.AdminCustom;
import com.cskaoyan.springboot.demo.mapper.AdminMapper;
import com.cskaoyan.springboot.demo.realm.MallToken;
import com.cskaoyan.springboot.demo.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/auth")
public class TestController {

    @Resource
    AdminMapper adminMapper;
    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public BaseRespModel login(@RequestBody Admin admin){

        String username = admin.getUsername();
        String password = admin.getPassword();
        MallToken mallToken = new MallToken(username,password,"admin");
        Subject subject = SecurityUtils.getSubject();
        subject.login(mallToken);
        BaseRespModel<Object> model = new BaseRespModel<>();
        model.setErrno(0);
        Serializable id = subject.getSession().getId();
        model.setData(id);
        model.setErrmsg("成功");
        return model;
    }

    @RequestMapping("info")
    @ResponseBody
    public UserMessage info(){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();//获取用户名
        UserMessage userMessage = new UserMessage();
        userMessage.setErrno(0);
        userMessage.setErrmsg("成功");
        UserLoginInfo data = adminService.queryAdminByUsername(principal);
        userMessage.setData(data);
        return userMessage;

    }

//    @RequestMapping("info")
//    @ResponseBody
//    public Info info(){
//        String principal = (String) SecurityUtils.getSubject().getPrincipal();//获取用户名
//        Info info = new Info();
//        info.setErrno(0);
//        info.setErrmsg("成功");
//        Data data = new Data();
//        data.setName(principal);
//        AdminVo adminVo = new AdminVo();
//        adminVo = adminMapper.queryAdmin(principal);
//        data.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        List<String> perms = adminMapper.queryPermissionsByUserName(principal);
//
//        List<String> roles = new ArrayList<>();
//        roles.add("超级管理员");
//        data.setPerms(perms);
//        data.setRoles(roles);
//        info.setData(data);
//        return info;
//
//    }


    @RequestMapping("logout")
    @ResponseBody
    public BaseRespModel logout(){
        SecurityUtils.getSubject().logout();
        BaseRespModel baseRespModel = new BaseRespModel();
        baseRespModel.setErrno(0);
        baseRespModel.setErrmsg("成功");

        return baseRespModel;

    }



}
