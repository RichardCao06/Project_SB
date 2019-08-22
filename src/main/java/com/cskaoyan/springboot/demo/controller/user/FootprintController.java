package com.cskaoyan.springboot.demo.controller.user;


import com.cskaoyan.springboot.demo.bean.Errno;
import com.cskaoyan.springboot.demo.bean.Footprint;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.service.user.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/footprint")
public class FootprintController {
    @Autowired
    FootprintService footprintService;

    @RequestMapping("list")
    public Object list(int page,int limit,Integer userId,Integer goodsId,String sort,String order){
        PageBean<Footprint> footprints = footprintService.findByCondition(page, limit, userId, goodsId, sort, order);
        return new Errno<Footprint>(footprints,"成功",0);
    }
}
