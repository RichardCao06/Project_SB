package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public interface AttributeService {
    int insertSelective(Attribute record);

    List<Attribute> queryByGoodsId(@Param("goodsId") int goodsId);

    int updateByPrimaryKey(Attribute record);

    int deleteByPrimaryKey(Integer id);

    List<Attribute> getAttributeByGoodsId(int goodsId);
}
