package com.cskaoyan.springboot.demo.bean.wx.category;

import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelTwo;

import java.util.List;

public class WxCategoryData {
    private List<CategoryLevelOne> categoryList;
    private CategoryLevelOne currentCategory;
    private List<CategoryLevelTwo> currentSubCategory;

    public List<CategoryLevelOne> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryLevelOne> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryLevelOne getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CategoryLevelOne currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<CategoryLevelTwo> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<CategoryLevelTwo> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }

    @Override
    public String toString() {
        return "WxCategoryData{" +
                "categoryList=" + categoryList +
                ", currentCategory=" + currentCategory +
                ", currentSubCategory=" + currentSubCategory +
                '}';
    }
}
