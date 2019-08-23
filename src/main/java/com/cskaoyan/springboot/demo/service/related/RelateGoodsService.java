package com.cskaoyan.springboot.demo.service.related;

import com.cskaoyan.springboot.demo.bean.Goods;

import java.util.List;

public interface RelateGoodsService {

    public List<Goods> selectGoodsByCategoryID(Integer categoryId);

}
