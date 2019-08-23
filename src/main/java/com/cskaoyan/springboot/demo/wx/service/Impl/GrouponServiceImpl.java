package com.cskaoyan.springboot.demo.wx.service.Impl;

import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.mapper.GrouponRulesMapper;
import com.cskaoyan.springboot.demo.wx.service.GrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/22
 */
@Service
public class GrouponServiceImpl implements GrouponService {

    @Autowired
    GrouponRulesMapper grouponRulesMapper;


    @Override
    public List<Groupon> getGrouponRulesByGoodsId(int goodsId) {
        return grouponRulesMapper.getGrouponRulesByGoodsId(goodsId);
    }
}
