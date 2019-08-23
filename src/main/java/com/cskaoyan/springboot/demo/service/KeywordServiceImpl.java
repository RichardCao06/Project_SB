package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Keyword;
import com.cskaoyan.springboot.demo.bean.KeywordExample;
import com.cskaoyan.springboot.demo.mapper.KeywordMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    /**
     * 得到所有isHot字段为true的Keyword对象
     * @return
     */
    public List<Keyword> find_HotKeyword(){
        //先得到所有keyword
        KeywordExample example = new KeywordExample();
        List<Keyword> keywordList = keywordMapper.selectByExample(example);
        //遍历这个List,若该对象isHot字段为false，则删去该对象
        List<Keyword> keywords = new ArrayList<>();
        for (Keyword keyword : keywordList) {
            if(keyword.getIsHot() == true){
                keywords.add(keyword);
            }
        }

        return keywords;
    }

    /**
     * 得到搜索框中的默认搜索
     * @return
     */
    public Keyword get_DefaultKeyword(){
        //先得到所有keyword
        KeywordExample example = new KeywordExample();
        example.createCriteria();
        List<Keyword> keywordList = keywordMapper.selectByExample(example);
        //如果所有keyword都没有设置default，那么就默认显示第一个keyword
        Keyword default_one = null;
        if (keywordList.size()!=0 && keywordList.get(0)!= null){
            default_one =keywordList.get(0);
        }
        //遍历这个List,找到isDefault字段为true的keywor对象
        for (Keyword keyword : keywordList) {
            if ( keyword.getIsDefault() == false){
                default_one = keyword;
            }
        }

        return default_one;
    }
}
