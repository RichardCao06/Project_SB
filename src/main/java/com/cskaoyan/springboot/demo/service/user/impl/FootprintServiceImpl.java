package com.cskaoyan.springboot.demo.service.user.impl;


import com.cskaoyan.springboot.demo.bean.Footprint;
import com.cskaoyan.springboot.demo.bean.FootprintExample;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.mapper.FootprintMapper;
import com.cskaoyan.springboot.demo.service.user.FootprintService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {
    @Resource
    FootprintMapper footprintMapper;

    @Override
    public PageBean<Footprint> findByCondition(int page, int limit, Integer userId, Integer goodsId, String sort, String order) {
        PageHelper.startPage(page,limit);
        FootprintExample footprintExample = new FootprintExample();
        FootprintExample.Criteria criteria = footprintExample.createCriteria();
        if(!("".equals(userId)||userId==null)){
            criteria = criteria.andUserIdEqualTo(userId);
        }
        if(!("".equals(goodsId)||goodsId==null)){
            criteria = criteria.andGoodsIdEqualTo(goodsId);
        }
        if(!("".equals(sort)||sort==null)){
            footprintExample.setOrderByClause(sort + " " + order);
        }
        List<Footprint> footprints = footprintMapper.selectByExample(footprintExample);
        long total = footprintMapper.countByExample(footprintExample);
        return new PageBean<Footprint>(footprints,total);
    }
}
