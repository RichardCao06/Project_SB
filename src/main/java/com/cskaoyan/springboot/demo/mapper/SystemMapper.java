package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.System;
import com.cskaoyan.springboot.demo.bean.SystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    List<String> selectByExample_config(SystemExample example);

    int update_mallconfig(@Param("name") String name, @Param("address") String address, @Param("phone") String phone, @Param("qq") String qq);
}