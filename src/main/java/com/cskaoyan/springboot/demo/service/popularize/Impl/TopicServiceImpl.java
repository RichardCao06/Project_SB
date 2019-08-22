package com.cskaoyan.springboot.demo.service.popularize.Impl;

import com.cskaoyan.springboot.demo.bean.Topic;

import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.TopicMapper;
import com.cskaoyan.springboot.demo.service.popularize.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TopicServiceImpl implements TopicService {
    @Resource
    TopicMapper topicMapper;
    @Override
    public ResponVo list(int page, int limit, String sort, String order, String title, String subtitle) {
        PageHelper.startPage(page,limit);
        if (title == null) title = "";
        if (subtitle == null) subtitle = "";

        List<Topic> topicList=topicMapper.getList(sort,order,title,subtitle);
        PageInfo<Topic> couponPageInfo = new PageInfo<>(topicList);
        return  new ResponVo<Topic>((int)couponPageInfo.getTotal(),topicList);

    }

     @Override
    public int update(Topic topic) {
        int i=topicMapper.updateByPrimaryKey(topic);
        return i;
    }

    @Override
    public void delect(Topic topic) {
        topicMapper.deleteByPrimaryKey(topic.getId());
    }

    @Override
    public void create(Topic topic) {

        topicMapper.insert(topic);
    }

}
