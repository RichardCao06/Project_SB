package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.bean.Category;
import com.cskaoyan.springboot.demo.mapper.CategoryMapper;
import com.cskaoyan.springboot.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int queryPidById(int id) {
        return categoryMapper.queryPidById(id);
    }

    @Override
    public List<Category> queryAllCategories(Integer currentCategoryId) {
        return categoryMapper.queryAllCategoriesL2(currentCategoryId);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
