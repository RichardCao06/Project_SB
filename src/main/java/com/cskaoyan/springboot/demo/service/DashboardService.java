package com.cskaoyan.springboot.demo.service;


import com.cskaoyan.springboot.demo.bean.GoodsExample;
import com.cskaoyan.springboot.demo.bean.GoodsProductExample;
import com.cskaoyan.springboot.demo.bean.OrderExample;
import com.cskaoyan.springboot.demo.bean.UserExample;

public interface DashboardService {

    long countByExample(UserExample example);

    long countByExample(GoodsExample example);

    long countByExample(GoodsProductExample example);

    long countByExample(OrderExample example);
}
