package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.GoodsProduct;
import com.cskaoyan.springboot.demo.bean.GoodsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsProductMapper {
    long countByExample(GoodsProductExample example);

    int deleteByExample(GoodsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsProduct record);

    int insertSelective(GoodsProduct record);

    List<GoodsProduct> selectByExample(GoodsProductExample example);

    GoodsProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByExample(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByPrimaryKeySelective(GoodsProduct record);

    int updateByPrimaryKey(GoodsProduct record);
}