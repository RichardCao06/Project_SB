package com.cskaoyan.springboot.demo.service.related.impl;

import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.bean.GoodsExample;
import com.cskaoyan.springboot.demo.mapper.GoodsMapper;
//import com.cskaoyan.springboot.demo.service.goods.GoodsService;
import com.cskaoyan.springboot.demo.service.related.RelateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RelateGoodsServiceImpl implements RelateGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * 通过categoryId得到商品的集合
     * @param categoryId
     * @return
     */
    @Override
    public List<Goods> selectGoodsByCategoryID(Integer categoryId) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);

        return goodsMapper.selectByExample(goodsExample);
    }
}
