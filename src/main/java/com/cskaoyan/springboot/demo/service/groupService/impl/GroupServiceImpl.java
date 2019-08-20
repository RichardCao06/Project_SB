package com.cskaoyan.springboot.demo.service.groupService.impl;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.GrouponRulesExample;
import com.cskaoyan.springboot.demo.bean.mall.DataWithItemAndTotal;
import com.cskaoyan.springboot.demo.mapper.GrouponRulesMapper;
import com.cskaoyan.springboot.demo.service.groupService.GroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Override
    public DataWithItemAndTotal findGroupRulesListByPageByCondition(int page, int limit, Integer goodsid) {
        PageHelper.startPage(page,limit);
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria();
        //如果商品id参数存在则将其附加附加至查询条件
        if(goodsid != null){
            grouponRulesExample.createCriteria().andGoodsIdEqualTo(goodsid);
        }
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        //通过pageInfo获取总数
        PageInfo<GrouponRules> objectPageInfo = new PageInfo<GrouponRules>(grouponRules);
        int total = (int)objectPageInfo.getTotal();
        //将查询的List和total封装入bean
        DataWithItemAndTotal dataWithItemAndTotal = new DataWithItemAndTotal();
        dataWithItemAndTotal.setItems(grouponRules);
        dataWithItemAndTotal.setTotal(total);
        return dataWithItemAndTotal;
    }

    @Override
    public int updateGroupRules(GrouponRules grouponRules) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andIdEqualTo(grouponRules.getId());
        int i = grouponRulesMapper.updateByExample(grouponRules, grouponRulesExample);
        return i;
    }

    @Override
    public int deleteGroupRules(GrouponRules grouponRules) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andIdEqualTo(grouponRules.getId());
        int i = grouponRulesMapper.deleteByExample(grouponRulesExample);
        return i;
    }
}
