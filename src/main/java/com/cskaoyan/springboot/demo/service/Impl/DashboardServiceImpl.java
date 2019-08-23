package com.cskaoyan.springboot.demo.service.Impl;


import com.cskaoyan.springboot.demo.bean.GoodsExample;
import com.cskaoyan.springboot.demo.bean.GoodsProductExample;
import com.cskaoyan.springboot.demo.bean.OrderExample;
import com.cskaoyan.springboot.demo.bean.UserExample;
import com.cskaoyan.springboot.demo.mapper.GoodsMapper;
import com.cskaoyan.springboot.demo.mapper.GoodsProductMapper;
import com.cskaoyan.springboot.demo.mapper.OrderMapper;
import com.cskaoyan.springboot.demo.mapper.UserMapper;
import com.cskaoyan.springboot.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsProductMapper goodsproductMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public long countByExample(GoodsExample example) {
        return goodsMapper.countByExample(example);
    }

    @Override
    public long countByExample(GoodsProductExample example) {
        return goodsproductMapper.countByExample(example);
    }

    @Override
    public long countByExample(OrderExample example) {
        return orderMapper.countByExample(example);
    }
}
