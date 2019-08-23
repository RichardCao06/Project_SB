package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Category;
import com.cskaoyan.springboot.demo.bean.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /*```````````````````````````````*/

    int queryPidById(int id);

    List<Category> queryAllCategoriesL2(@Param("id") Integer id);

    Category selectByPrimaryKey(Integer id);

    List<Category> getFilterCategoryList(@Param("keyword") String keyword);
}