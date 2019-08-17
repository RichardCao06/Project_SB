package com.cskaoyan.springboot.demo.controller.user;

import com.cskaoyan.springboot.demo.bean.Errno;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.Collect;
import com.cskaoyan.springboot.demo.service.user.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("list")
    public Object list(int page,int limit,Integer userId,Integer valueId,String sort,String order){
        PageBean<Collect> collects = collectService.findByCondition(page, limit, userId, valueId, sort, order);
        return new Errno<Collect>(collects,"成功",0);
    }
}
