package com.cskaoyan.springboot.demo.service.popularize.Impl;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.GrouponRulesMapper;
import com.cskaoyan.springboot.demo.service.popularize.GrouponRulesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GrouponRulesServiceImpl implements GrouponRulesService {
     @Resource
     GrouponRulesMapper grouponRulesMapper;
     @Override
    public ResponVo<GrouponRules> getList(int page, int limit, String sort, String order, String goodsId) {
        PageHelper.startPage(page, limit);
        List<GrouponRules> couponList = grouponRulesMapper.getList(sort , order ,goodsId );
        PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(couponList);
        ResponVo<GrouponRules> grouponRulesPageVO = new ResponVo<>((int)grouponRulesPageInfo.getTotal(),grouponRulesPageInfo.getList());
        return  grouponRulesPageVO ;
    }

    @Override
    public int create(GrouponRules grouponRules) {
        return grouponRulesMapper.create(grouponRules);
    }

    @Override
    public GrouponRules findGoodsId(Integer goodsId) {
        return grouponRulesMapper.findGoodsId(goodsId);
    }

    @Override
    public int delete(GrouponRules grouponRules) {
        return grouponRulesMapper.deleteByPrimaryKey(grouponRules.getId());
    }

    @Override
    public int update(GrouponRules grouponRules) {
        return grouponRulesMapper.updateByPrimaryKeySelective(grouponRules);
    }

    @Override
    public List<GrouponRules> wxGetList(int page, int size) {
        PageHelper.startPage(page, size);
        return  grouponRulesMapper.queryAll();
    }

    @Override
    public int count() {
        return grouponRulesMapper.count();
    }

    @Override
    public GrouponRules getRulesId(Integer rulesId) {
        return grouponRulesMapper.selectByPrimaryKey(rulesId);
    }
}
