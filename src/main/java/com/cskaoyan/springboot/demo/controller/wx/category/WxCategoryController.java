package com.cskaoyan.springboot.demo.controller.wx.category;

import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelTwo;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.bean.wx.category.WxCategoryData;
import com.cskaoyan.springboot.demo.bean.wx.category.WxRelateCategoryData;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx")
public class WxCategoryController {
    @Autowired
    MallService mallService;
    @RequestMapping("catalog/index")
    public MessageWithData showCategoryList(){
        MessageWithData messageWithData = new MessageWithData();
        WxCategoryData wxCategoryData = new WxCategoryData();
        //1. 获取第一级的商品类目
        List<CategoryLevelOne> categoryList = mallService.findCategoryList();
        wxCategoryData.setCategoryList(categoryList);
        //2. 获取第一个一级商品类目
        CategoryLevelOne firstCategory = categoryList.get(0);
        wxCategoryData.setCurrentCategory(firstCategory);
        //3. 获取第一个一级目录的所有二级目录
        List<CategoryLevelTwo> subCategory = firstCategory.getChildren();
        wxCategoryData.setCurrentSubCategory(subCategory);

        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(wxCategoryData);

        return messageWithData;

    }

    @RequestMapping("catalog/current")
    public MessageWithData showCurrentCategory(int id){
        MessageWithData messageWithData = new MessageWithData();
        WxCategoryData wxCategoryData = new WxCategoryData();
        //1. 根据id获取当前的商品类目
        CategoryLevelOne currentCategory = mallService.findCategoryById(id);
        wxCategoryData.setCurrentCategory(currentCategory);
        //2. 获取当前类目的二级类目列表
        List<CategoryLevelTwo> subCategory = currentCategory.getChildren();
        wxCategoryData.setCurrentSubCategory(subCategory);

        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(wxCategoryData);
        //messageWithData = createMessageWithData(wxCategoryData,messageWithData);

        return messageWithData;
    }

    @RequestMapping("goods/category")
    public MessageWithData showRelateCategory(@Param("id") int id){
        MessageWithData messageWithData = new MessageWithData();
        WxRelateCategoryData wxRelateCategoryData = new WxRelateCategoryData();

        //1. 根据获取currentCategory
        CategoryLevelOne currentCategory = mallService.findCategoryById(id);
        wxRelateCategoryData.setCurrentCategory(currentCategory);
        //2. 根据当前category的pid获取parentCategory
        CategoryLevelOne fatherCategory = mallService.findCategoryById(currentCategory.getPid());
        wxRelateCategoryData.setParentCategory(fatherCategory);
        //3. 获取父类目的所有子目录即为兄弟类目
        List<CategoryLevelTwo> brotherCategory = fatherCategory.getChildren();
        wxRelateCategoryData.setBrotherCategory(brotherCategory);

        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(wxRelateCategoryData);
        return messageWithData;
    }


    /**
     * 根据wxCategoryData生成messageWithData
     * @param wxCategoryData
     * @param messageWithData
     * @return
     */
    /*public MessageWithData createMessageWithData(WxCategoryData wxCategoryData,MessageWithData messageWithData){
        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(wxCategoryData);
        return messageWithData;
    }*/

}
