package com.cskaoyan.springboot.demo.service;


import com.cskaoyan.springboot.demo.wx.bean.SpecificationWx;

import com.cskaoyan.springboot.demo.bean.Specification;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public interface SpecificationService {
    int insertSelective(Specification record);

    List<Specification> queryByGoodsId(int id);

    int updateByPrimaryKey(Specification specification);

    int deleteByPrimaryKey(Integer id);

    List<SpecificationWx> querySpecificationWxByGoodsId(int goodsId);
}
