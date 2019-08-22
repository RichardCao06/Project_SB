package com.cskaoyan.springboot.demo.mapper;


import java.util.List;

import com.cskaoyan.springboot.demo.bean.Picture;
import com.cskaoyan.springboot.demo.bean.Storage;
import com.cskaoyan.springboot.demo.bean.StorageExample;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    List<Storage> getAllStorage();

    int updateById(@Param("name")String name,@Param("id")int id);

    List<Storage> searchByNameAndKey(@Param("key")String key,@Param("name")String name);

    int insertPic(@Param("pic") Picture picture);
}