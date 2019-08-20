package com.cskaoyan.springboot.demo.controller;

import com.cskaoyan.springboot.demo.bean.BaseRespModel;
import com.cskaoyan.springboot.demo.bean.User;
import com.cskaoyan.springboot.demo.realm.MallToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
@RequestMapping("wx/auth")
public class LoginController {

    @RequestMapping("login")
    @ResponseBody
    public BaseRespModel login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        MallToken mallToken = new MallToken(username,password,"wx");
        Subject subject = SecurityUtils.getSubject();
        subject.login(mallToken);
        BaseRespModel<Object> model = new BaseRespModel<>();
        model.setErrno(0);
        Serializable id = subject.getSession().getId();
        model.setData(id);
        model.setErrmsg("成功");
        return model;
    }



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
