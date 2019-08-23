package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Specification;
import com.cskaoyan.springboot.demo.wx.bean.SpecificationWx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/20
 */
public interface SpecificationMapper {

    int insertSelective(Specification record);

    List<Specification> queryByGoodsId(@Param("id") int id);

    int updateByPrimaryKey(Specification record);

    int deleteByPrimaryKey(Integer id);

    List<SpecificationWx> querySpecificationWxByGoodsId(@Param("goodsId") int goodsId);
}
