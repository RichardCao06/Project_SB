package com.cskaoyan.springboot.demo.config;

import com.cskaoyan.springboot.demo.bean.Admin;
import com.cskaoyan.springboot.demo.bean.AdminExample;
import com.cskaoyan.springboot.demo.bean.Log;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.service.systemservice.LogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;


@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Autowired
    LogService logService;

   /* @Pointcut("execution(com.cskaoyan.springboot.demo.bean.systembean.ResponseVo com.cskaoyan.springboot.demo.controller.systemcontroller.AdministratorController.admincreate(com.cskaoyan.springboot.demo.bean.systembean.Admin2))")
    public void log(){
    }*/

    /*Controller层切入点*/
    @Pointcut("@annotation(com.cskaoyan.springboot.demo.util.ControllerLog)")
    public void log(){}

    /*service层切入点：用于处理异常信息*/
    @Pointcut("@annotation(com.cskaoyan.springboot.demo.util.ServiceLog)")
    public void serviceLog(){

    }

    @Before("serviceLog()")
    public void before(JoinPoint joinPoint){
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
       /* Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();*/
        /*目前无法拿到登录人的信息，有待改进*/
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        Log log = new Log();
        Date date = new Date();

        // log.setAdmin(principal);
        Object proceed = joinPoint.proceed();

        /*获取IP*/
        InetAddress localHost = InetAddress.getLocalHost();
        String address = localHost.getHostAddress();
        log.setIp(address);

        /*利用反射获取参数bean中的属性值*/
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            //System.out.println(arg.toString());
            Field[] fields = arg.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                if(name == "username"){
                    String o = (String) field.get(arg);
                    /*操作对象的name*/
                    log.setResult(o);
                }
            }
        }

        /*获取方法名*/
        String methodName = joinPoint.getSignature().getName();
        switch(methodName){
            case "admincreate":log.setAction("添加管理员");log.setType(1);log.setStatus(true);log.setAddTime(date);log.setUpdateTime(date);break;
            case "deleteadmin":log.setAction("删除管理员");log.setType(1);log.setStatus(true);log.setUpdateTime(date);log.setAddTime(date);break;
            case "updateadmin":log.setAction("更新管理员");log.setType(1);log.setStatus(true);log.setUpdateTime(date);log.setAddTime(date);break;
            default:break;
        }
        logService.insertLog(log);

        return proceed;
    }

    @After("log()")
    public void after(){

    }

    @AfterThrowing("serviceLog()")
    public void afterthrow(JoinPoint joinPoint){
        Date date = new Date();
        Log log = new Log();
        /*获取IP*/
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String address = localHost.getHostAddress();
        log.setIp(address);

        /*获取方法*/
        String name = joinPoint.getSignature().getName();
        switch(name){
            case "insertAdmin":log.setAction("添加管理员");log.setType(0);log.setStatus(false);log.setAddTime(date);log.setUpdateTime(date);log.setComment("用户名已经存在");break;
            case "deleteAdmin":log.setAction("删除管理员");log.setType(0);log.setStatus(false);log.setUpdateTime(date);log.setAddTime(date);break;
            case "updateAdmin":log.setAction("更新管理员");log.setType(0);log.setStatus(false);log.setUpdateTime(date);log.setAddTime(date);break;
            default:break;
        }

        logService.insertLog(log);
    }

}
