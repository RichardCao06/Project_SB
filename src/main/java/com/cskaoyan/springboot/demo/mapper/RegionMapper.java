package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Region;
import com.cskaoyan.springboot.demo.bean.RegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionMapper {
    long countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Region record);

    int insertSelective(Region record);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    List<Region> queryRegionByPid(@Param("pid")int pid);
}