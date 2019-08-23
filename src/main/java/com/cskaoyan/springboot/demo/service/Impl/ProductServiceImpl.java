package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.bean.Product;
import com.cskaoyan.springboot.demo.mapper.ProductMapper;
import com.cskaoyan.springboot.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public List<Product> queryByGoodsId(int goodsId) {
        return productMapper.queryByGoodsId(goodsId);
    }

    @Override
    public int updateByPrimaryKey(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }
}
