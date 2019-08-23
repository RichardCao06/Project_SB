package com.cskaoyan.springboot.demo.wx.WxConfig;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Footprint;
import com.cskaoyan.springboot.demo.bean.Log;
import com.cskaoyan.springboot.demo.mapper.FootprintMapper;
import com.cskaoyan.springboot.demo.realm.UserTokenManager;
import com.cskaoyan.springboot.demo.service.systemservice.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;


@Component
@Aspect
public class WxAspect {

   @Autowired
    FootprintMapper footprintMapper;

    //Logger logger = Logger.getLogger(this.getClass());
   /* @Pointcut("execution(com.cskaoyan.springboot.demo.bean.systembean.ResponseVo com.cskaoyan.springboot.demo.controller.systemcontroller.AdministratorController.admincreate(com.cskaoyan.springboot.demo.bean.systembean.Admin2))")
    public void log(){
    }*/
    /*Controller层注解*/
   @Pointcut("@annotation(com.cskaoyan.springboot.demo.util.WxControllerLog)")
   public void log(){}

   @Before("log()")
   public void before(){

    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        Footprint footprint = new Footprint();
        footprint.setUserId(1);

        Object proceed = joinPoint.proceed();

        Object[] args = joinPoint.getArgs();
        int goodsId = (int) args[0];

        footprint.setDeleted(true);
        footprint.setGoodsId(goodsId);
        footprint.setAddTime(new Date());
        footprint.setUpdateTime(new Date());

        footprintMapper.insert(footprint);


        return proceed;
    }
}
