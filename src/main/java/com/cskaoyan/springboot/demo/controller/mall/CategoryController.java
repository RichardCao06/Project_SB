package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.MallMessage;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    MallService mallService;

    /**
     * 获取CategoryList的数据
     * @return
     */
    @RequestMapping("category/list")
    public MallMessage showCategoryList(){
        MallMessage mallMessage = new MallMessage();
        List<CategoryLevelOne> categoryLevelList = mallService.findCategoryList();
        if(categoryLevelList != null){
            mallMessage.setErrno(0);
            mallMessage.setErrmsg("成功");
            mallMessage.setData(categoryLevelList);
            return mallMessage;
        }
        return null;
    }

    @RequestMapping("category/update")
    public MallMessage updateCategory(@RequestBody CategoryLevelOne categoryLevelOne){
        MallMessage mallMessage = new MallMessage();
        int num = mallService.updateCategory(categoryLevelOne);
        if(num > 0){
            mallMessage.setErrno(0);
            mallMessage.setErrmsg("成功");
            return mallMessage;
        }
        return null;
    }

    @RequestMapping("category/l1")
    public MallMessage findLevelOneCategory(){
        MallMessage mallMessage = new MallMessage();
        List<CategoryData> categoryDataList = mallService.findLevelOneCategory();
        if(categoryDataList != null){
            mallMessage.setErrno(0);
            mallMessage.setErrmsg("成功");
            mallMessage.setData(categoryDataList);
            return mallMessage;
        }
        return null;
    }

    @RequestMapping("category/delete")
    public MallMessage deleteCategory(@RequestBody CategoryLevelOne categoryLevelOne){
        MallMessage mallMessage = new MallMessage();
        int num = mallService.deleteCategoryById(categoryLevelOne.getId());
        if(num > 0){
            mallMessage.setErrno(0);
            mallMessage.setErrmsg("成功");
            return mallMessage;
        }
        return null;
    }
 }
