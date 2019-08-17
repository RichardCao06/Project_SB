package com.cskaoyan.springboot.demo.service.user.impl;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.SearchHistory;
import com.cskaoyan.springboot.demo.bean.SearchHistoryExample;
import com.cskaoyan.springboot.demo.mapper.SearchHistoryMapper;
import com.cskaoyan.springboot.demo.service.user.SearchHistoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Resource
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public PageBean<SearchHistory> findByCondition(int page, int limit, Integer userId, String keyword, String sort, String order) {
        PageHelper.startPage(page,limit);
        SearchHistoryExample searchHistoryExample = new SearchHistoryExample();
        SearchHistoryExample.Criteria criteria = searchHistoryExample.createCriteria();
        if(!("".equals(userId)||userId==null)){
            criteria = criteria.andUserIdEqualTo(userId);
        }
        if(!("".equals(keyword)||keyword==null)){
            criteria = criteria.andKeywordLike("%" + keyword + "%");
        }
        if(!("".equals(sort)||sort==null)){
            searchHistoryExample.setOrderByClause(sort + " " + order);
        }
        List<SearchHistory> searchHistories = searchHistoryMapper.selectByExample(searchHistoryExample);
        long total = searchHistoryMapper.countByExample(searchHistoryExample);
        return new PageBean<SearchHistory>(searchHistories,total);
    }
}
