package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.mall.MessageWithList;

import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("admin")
public class RegionListController {
    @Autowired
    MallService mallService;

    /**
     * 返回行政区域数据
     * @return
     */
    @RequestMapping("region/list")
    public MessageWithList showRegionList(){
        MessageWithList message = new MessageWithList();
        List<Province> regionList = mallService.findRegionList();
        if (regionList != null){
            message.setErrno(0);
            message.setErrmsg("成功");
            message.setData(regionList);
            System.out.println(message);
            return message;

        }
        return null;
    }
}
