/*
package com.cskaoyan.springboot.demo.service.popularize.Impl;

import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.GrouponMapper;
import com.cskaoyan.springboot.demo.mapper.GrouponRulesMapper;
import com.cskaoyan.springboot.demo.service.popularize.GrouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GrouponServiceImpl implements GrouponService {
    @Resource
    GrouponMapper grouponMapper;
    @Resource
    GrouponRulesMapper grouponRulesMapper;
    @Override
    public ResponVo list(int page, int limit, String sort, String order, String goodsId) {
        PageHelper.startPage(page, limit);
        List<Groupon> grouponList = grouponMapper.getListRecord(sort , order ,goodsId  );
        PageInfo<Groupon> grouponPageInfo = new PageInfo<>(grouponList);
        ResponVo<Groupon> grouponPageVO = new ResponVo((int)grouponPageInfo.getTotal(),grouponPageInfo.getList());
        return  grouponPageVO ;

    }

    public int create(GrouponRules grouponRules) {
        return grouponMapper.create(grouponRules);
    }

    @Override
    public Groupon findRulesId(Integer id) {
        return null;
    }

    @Override
    public List<Groupon> getWxGrouponList() {
        return grouponMapper.getWxGrouponList();
    }

    @Override
    public List<Groupon> getGrouponRulesByGoodsId(int goodsId) {
        return grouponRulesMapper.getGrouponRulesByGoodsId(goodsId);
    }

    @Override
    public List<Groupon> queryAll() {
        return grouponMapper.queryAll();
    }

    @Override
    public int count() {
        return grouponMapper.count();
    }

    @Override
    public int countGrouponId() {
        return grouponMapper.countGrouponId();
    }

    @Override
    public Groupon getGrouponId(int grouponId) {
        return grouponMapper.selectByPrimaryKey(grouponId);
    }

}
*/
