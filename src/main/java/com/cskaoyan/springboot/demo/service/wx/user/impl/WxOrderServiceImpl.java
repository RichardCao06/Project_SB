package com.cskaoyan.springboot.demo.service.wx.user.impl;


import com.cskaoyan.springboot.demo.bean.OrderExample;
import com.cskaoyan.springboot.demo.mapper.OrderMapper;
import com.cskaoyan.springboot.demo.service.wx.user.WxOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WxOrderServiceImpl implements WxOrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public int countByExample(int userId,int orderStatus) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)orderStatus);

        long count = orderMapper.countByExample(orderExample);
        return (int)count;
    }
}
