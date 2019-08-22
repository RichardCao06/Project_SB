package com.cskaoyan.springboot.demo.bean.wx.category;

import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelTwo;

import java.util.List;

public class WxRelateCategoryData {
    private CategoryLevelOne currentCategory;
    private CategoryLevelOne parentCategory;
    private List<CategoryLevelTwo> brotherCategory;

    public CategoryLevelOne getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CategoryLevelOne currentCategory) {
        this.currentCategory = currentCategory;
    }

    public CategoryLevelOne getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryLevelOne parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<CategoryLevelTwo> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<CategoryLevelTwo> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    @Override
    public String toString() {
        return "WxRelateCategoryData{" +
                "currentCategory=" + currentCategory +
                ", parentCategory=" + parentCategory +
                ", brotherCategory=" + brotherCategory +
                '}';
    }
}
