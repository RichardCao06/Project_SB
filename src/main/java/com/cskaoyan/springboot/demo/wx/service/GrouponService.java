package com.cskaoyan.springboot.demo.wx.service;

import com.cskaoyan.springboot.demo.bean.Groupon;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/22
 */
public interface GrouponService {
    List<Groupon> getGrouponRulesByGoodsId(int goodsId);
}
