package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Keyword;
import com.cskaoyan.springboot.demo.bean.KeywordExample;
import com.cskaoyan.springboot.demo.mapper.KeywordMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Resource
    KeywordMapper keywordMapper;

    @Override
    public List<Keyword> findKeyword(String keyword, String url, int page, int limit) {

        KeywordExample example = new KeywordExample();
        KeywordExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(keyword)){
            criteria.andKeywordLike("%" + keyword + "%");
        }
        if(!StringUtils.isEmpty(url)){
            criteria.andUrlLike("%" + url + "%");
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, limit);
        return  keywordMapper.selectByExample(example);
    }

    @Override
    public Keyword update(Keyword keyword) {

        keyword.setUpdateTime(LocalDateTime.now());
        keywordMapper.updateByPrimaryKey(keyword);
        Keyword select = keywordMapper.selectByPrimaryKey(keyword.getId());
        return select;

    }

    @Override
    public Keyword insert(Keyword keyword) {
        keyword.setAddTime(LocalDateTime.now());
        keyword.setUpdateTime(LocalDateTime.now());
        keywordMapper.insertSelective(keyword);
        int id = keywordMapper.queryKeywordById();
        Keyword select = keywordMapper.selectByPrimaryKey(id);
        return select;

    }

    @Override
    public void delete(Keyword keyword) {

        keywordMapper.deleteByPrimaryKey(keyword.getId());
    }
}
