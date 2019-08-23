package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/20
 */
public interface ProductMapper {
    int insert(Product record);

    List<Product> queryByGoodsId(int goodsId);

    int updateByPrimaryKey(@Param("product") Product product);

    int deleteByPrimaryKey(Integer id);
}
