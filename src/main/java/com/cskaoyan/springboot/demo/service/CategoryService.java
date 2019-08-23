package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Category;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public interface CategoryService {
    int queryPidById(int id);

    List<Category> queryAllCategories(Integer currentCategoryId);

    Category getCategoryById(Integer id);
}
