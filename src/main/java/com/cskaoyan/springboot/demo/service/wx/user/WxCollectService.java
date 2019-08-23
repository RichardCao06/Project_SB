package com.cskaoyan.springboot.demo.service.wx.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.WxCollect;

public interface WxCollectService {
    PageBean<WxCollect> findByUserId(int page, int limit, Integer userId, Byte type);

    String update(Integer userId, Byte type, Integer valueId);

}
