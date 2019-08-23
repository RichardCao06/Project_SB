package com.cskaoyan.springboot.demo.service.wx.user;

public interface WxOrderService {
    public int countByExample(int userId, int orderStatus);
}
