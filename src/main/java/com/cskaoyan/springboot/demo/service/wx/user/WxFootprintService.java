package com.cskaoyan.springboot.demo.service.wx.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.WxFootPrint;

public interface WxFootprintService {
    PageBean<WxFootPrint> findByUserId(int page, int size, Integer userId);
}
