package com.cskaoyan.springboot.demo.mapper.mall;

import com.cskaoyan.springboot.demo.bean.Category;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryListMapper {

    List<CategoryLevelOne> findCategoryList(@Param("level") String level);

    List<CategoryLevelTwo> findCategoryLevelTwoByPid(@Param("pid") String pid);

    int updateCategory(@Param("category") CategoryLevelOne categoryLevelOne);

    List<CategoryData> findLevelOneCategoryList(@Param("level") String level);

    int deleteCategory(@Param("id") int id);

    int insertCategory(@Param("category") Category category);

    CategoryLevelOne findCategoryById(@Param("id") int id);
}
