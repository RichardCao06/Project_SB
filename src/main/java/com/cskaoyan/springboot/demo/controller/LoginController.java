package com.cskaoyan.springboot.demo.controller;

import com.cskaoyan.springboot.demo.bean.BaseRespModel;
import com.cskaoyan.springboot.demo.bean.BaseRespVo;
import com.cskaoyan.springboot.demo.bean.User;
import com.cskaoyan.springboot.demo.bean.UserInfo;
import com.cskaoyan.springboot.demo.mapper.UserMapper;
import com.cskaoyan.springboot.demo.realm.MallToken;
import com.cskaoyan.springboot.demo.realm.UserToken;
import com.cskaoyan.springboot.demo.realm.UserTokenManager;
import com.cskaoyan.springboot.demo.service.wx.user.WxOrderService;
import com.cskaoyan.springboot.demo.util.JacksonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("wx")
public class LoginController {
    @Resource
    UserMapper userMapper;

    @RequestMapping("auth/login")
    @ResponseBody
    public BaseRespVo login(@RequestBody String body,HttpServletRequest request){
        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");
        MallToken mallToken = new MallToken(username,password,"wx");
        Subject subject = SecurityUtils.getSubject();
        subject.login(mallToken);
        BaseRespModel<Object> model = new BaseRespModel<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(username);
        int userId =userMapper.queryIdByUsername(username);

        model.setErrno(0);
        Serializable id = subject.getSession().getId();
        model.setData(id);
        model.setErrmsg("成功");

        UserToken userToken = UserTokenManager.generateToken(userId);
        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", userToken.getToken());
        result.put("tokenExpire", userToken.getExpireTime().toString());
        result.put("userInfo", userInfo);
        return BaseRespVo.ok(result);

    }

    @Autowired
    WxOrderService wxOrderService;

    @RequestMapping("user/index")
    @ResponseBody
    public Object list(HttpServletRequest request) {
        //前端写了一个token放在请求头中
        //*************************
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        System.out.println(userId);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return BaseRespVo.fail();
        }

        Map<Object, Object> data = new HashMap<Object, Object>();
        //***********************************
        //根据userId查询订单信息
        HashMap<String, Integer> order = new HashMap<>();
        order.put("unpaid", wxOrderService.countByExample(userId, 101));
        order.put("unship", wxOrderService.countByExample(userId, 201));
        order.put("unrecv", wxOrderService.countByExample(userId, 301));
        order.put("uncomment", wxOrderService.countByExample(userId, 401));
        data.put("order", order);
        //***********************************

        return BaseRespVo.ok(data);
    }



    @RequestMapping("auth/logout")
    @ResponseBody
    public BaseRespModel logout(){
        SecurityUtils.getSubject().logout();
        BaseRespModel baseRespModel = new BaseRespModel();
        baseRespModel.setErrno(0);
        baseRespModel.setErrmsg("成功");

        return baseRespModel;

    }

    @RequestMapping("auth/regCaptcha")
    @ResponseBody
    public BaseRespModel phone(){

        BaseRespModel baseRespModel = new BaseRespModel();
        baseRespModel.setErrno(701);
        baseRespModel.setErrmsg("小程序后台验证码服务不支持");


        return baseRespModel;
    }
    @RequestMapping("auth/register")
    @ResponseBody
    public BaseRespModel register(){

        BaseRespModel baseRespModel = new BaseRespModel();
        baseRespModel.setErrno(703);
        baseRespModel.setErrmsg("验证码错误");

        return baseRespModel;
    }

    @RequestMapping("auth/login_by_weixin")
    @ResponseBody
    public BaseRespModel loginByWexin(){

        BaseRespModel baseRespModel = new BaseRespModel();
        baseRespModel.setErrno(-1);
        baseRespModel.setErrmsg("错误");

        return baseRespModel;
    }
}
