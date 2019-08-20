package com.cskaoyan.springboot.demo.controller.testController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wx")
@RestController
public class WxTestController {
    @RequestMapping("home/index")
    public String firstTest(){
        return "hello";
    }
}
