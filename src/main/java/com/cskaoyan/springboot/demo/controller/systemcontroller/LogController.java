package com.cskaoyan.springboot.demo.controller.systemcontroller;


import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.service.systemservice.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("log/list")
    public ResponseVo logList(int page, int limit, String sort, String order, String name) {
        if (name != null) {
            return logService.searchLog(page,limit,name);
        } else {
            return logService.queryAllLog(page, limit);
        }
    }

}
