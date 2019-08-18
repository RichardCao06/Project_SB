package com.cskaoyan.springboot.demo.controller.systemcontroller;

import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.service.systemservice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("log/list")
    public ResponseVo logList(int page,int limit,String sort,String order){
        return  logService.queryAllLog();
    }


}
