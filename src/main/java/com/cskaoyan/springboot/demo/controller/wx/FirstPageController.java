package com.cskaoyan.springboot.demo.controller.wx;


import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.DataWithItemAndTotal;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.bean.wx.FirstPageData;
import com.cskaoyan.springboot.demo.service.groupService.GroupService;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx")
public class FirstPageController {

    @Autowired
    MallService mallService;
    @Autowired
    GroupService groupService;

    @RequestMapping("home/index")
    public MessageWithData showFirstPage(){
        MessageWithData messageWithData = new MessageWithData();
        FirstPageData firstPageData = new FirstPageData();
        //1. 获取广告数据

        //2. 获取一级目录列表
        List<CategoryLevelOne> categoryList = mallService.findCategoryList();
        firstPageData.setChannel(categoryList);

        //3. 获取四个制造商的列表
        List<Brand> brandList = mallService.findBrandListByIdByName(1,4,null,null);
        firstPageData.setBrandList(brandList);

        //4. 获取分类商品列表

        //5. 获取四个团购列表
        DataWithItemAndTotal groupRulesListByPageByCondition = groupService.findGroupRulesListByPageByCondition(1, 4, null);
        List<Groupon> grouponList = groupRulesListByPageByCondition.getItems();
        firstPageData.setGrouponList(grouponList);

        //6. 获取热门商品列表

        //7. 获取新品商品列表

        //8. 获取话题列表



        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(firstPageData);
        return messageWithData;
    }
}
