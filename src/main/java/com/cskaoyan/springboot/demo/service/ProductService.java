package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public interface ProductService {
    int insert(Product record);

    List<Product> queryByGoodsId(int goodsId);

    int updateByPrimaryKey(@Param("product") Product product);

    int deleteByPrimaryKey(Integer id);
}
