package com.cskaoyan.springboot.demo.service.user.impl;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.Collect;
import com.cskaoyan.springboot.demo.bean.user.CollectExample;
import com.cskaoyan.springboot.demo.mapper.user.CollectMapper;
import com.cskaoyan.springboot.demo.service.user.CollectService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    CollectMapper collectMapper;

    @Override
    public PageBean<Collect> findByCondition(int page, int limit, Integer userId, Integer valueId, String sort, String order) {
        PageHelper.startPage(page,limit);
        CollectExample collectExample = new CollectExample();
        CollectExample.Criteria criteria = collectExample.createCriteria();
        if(!("".equals(userId)||userId==null)){
            criteria = criteria.andUserIdEqualTo(userId);
        }
        if(!("".equals(valueId)||valueId==null)){
            criteria = criteria.andValueIdEqualTo(valueId);
        }
        if(!("".equals(sort)||sort==null)){
            collectExample.setOrderByClause(sort + " " + order);
        }
        List<Collect> collects = collectMapper.selectByExample(collectExample);
        long total = collectMapper.countByExample(collectExample);
        return new PageBean<Collect>(collects,total);
    }
}
