package com.cskaoyan.springboot.demo.wx.service.Impl;

import com.cskaoyan.springboot.demo.bean.GoodsProduct;
import com.cskaoyan.springboot.demo.mapper.GoodsProductMapper;
import com.cskaoyan.springboot.demo.wx.service.GoodsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsProductImpl implements GoodsProductService {

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Override
    public GoodsProduct queryGPByGid(int id) {

        GoodsProduct goodsProduct = goodsProductMapper.selectByPrimaryKey(id);

        return goodsProduct;
    }
}
