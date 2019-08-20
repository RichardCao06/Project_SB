package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.Category;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithList;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class CategoryController {

    @Autowired
    MallService mallService;

    /**
     * 获取CategoryList的数据
     * @return
     */
    @RequestMapping("category/list")
    public MessageWithList showCategoryList(){
        MessageWithList messageWithList = new MessageWithList();
        List<CategoryLevelOne> categoryLevelList = mallService.findCategoryList();
        if(categoryLevelList != null){
            messageWithList.setErrno(0);
            messageWithList.setErrmsg("成功");
            messageWithList.setData(categoryLevelList);
            return messageWithList;
        }
        return null;
    }

    @RequestMapping("category/update")
    public MessageWithList updateCategory(@RequestBody CategoryLevelOne categoryLevelOne){
        MessageWithList messageWithList = new MessageWithList();
        int num = mallService.updateCategory(categoryLevelOne);
        if(num > 0){
            messageWithList.setErrno(0);
            messageWithList.setErrmsg("成功");
            return messageWithList;
        }
        return null;
    }

    @RequestMapping("category/l1")
    public MessageWithList findLevelOneCategory(){
        MessageWithList messageWithList = new MessageWithList();
        List<CategoryData> categoryDataList = mallService.findLevelOneCategory();
        if(categoryDataList != null){
            messageWithList.setErrno(0);
            messageWithList.setErrmsg("成功");
            messageWithList.setData(categoryDataList);
            return messageWithList;
        }
        return null;
    }

    @RequestMapping("category/delete")
    public MessageWithList deleteCategory(@RequestBody CategoryLevelOne categoryLevelOne){
        MessageWithList messageWithList = new MessageWithList();
        int num = mallService.deleteCategoryById(categoryLevelOne.getId());
        if(num > 0){
            messageWithList.setErrno(0);
            messageWithList.setErrmsg("成功");
            return messageWithList;
        }
        return null;
    }

    @RequestMapping("category/create")
    public MessageWithData addCategory(@RequestBody Category category){
        MessageWithData messageWithData = new MessageWithData();
        int num = mallService.addCategory(category);
        if(num > 0){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            messageWithData.setData(category);
            return messageWithData;
        }
        return null;
    }
 }
