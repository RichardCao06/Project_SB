package com.cskaoyan.springboot.demo.config;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Log;
import com.cskaoyan.springboot.demo.service.systemservice.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Autowired
    LogService logService;

    //Logger logger = Logger.getLogger(this.getClass());
   /* @Pointcut("execution(com.cskaoyan.springboot.demo.bean.systembean.ResponseVo com.cskaoyan.springboot.demo.controller.systemcontroller.AdministratorController.admincreate(com.cskaoyan.springboot.demo.bean.systembean.Admin2))")
    public void log(){
    }*/
    /*Controller层注解*/
   @Pointcut("@annotation(com.cskaoyan.springboot.demo.util.ControllerLog)")
   public void log(){}

   @Before("log()")
   public void before(){

    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("Admin");
        System.out.println(admin);
        Log log = new Log();
        System.out.println("before");
        Object proceed = joinPoint.proceed();
        String address = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
             address = localHost.getHostAddress();
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String name = joinPoint.getSignature().getName();
        Date date = new Date();
        log.setIp(address);
        switch(name){
            case "admincreate":log.setAction("添加管理员");log.setType(1);log.setStatus(true);log.setAddTime(date);log.setUpdateTime(date);break;
            case "deleteadmin":log.setAction("删除管理员");log.setType(1);log.setStatus(true);break;
            case "updateadmin":log.setAction("更新管理员");log.setType(1);log.setStatus(true);log.setUpdateTime(date);break;
            default:break;
        }
        ResponseVo responseVo = logService.insertLog(log);
        System.out.println(responseVo);
        System.out.println(name);
        System.out.println("after");
        return proceed;
    }
}
