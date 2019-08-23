package com.cskaoyan.springboot.demo.wx.service;

import com.cskaoyan.springboot.demo.bean.GoodsProduct;

public interface GoodsProductService {
    GoodsProduct queryGPByGid(int id);
}
