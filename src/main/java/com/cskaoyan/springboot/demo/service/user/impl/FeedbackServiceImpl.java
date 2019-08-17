package com.cskaoyan.springboot.demo.service.user.impl;


import com.cskaoyan.springboot.demo.bean.Feedback;
import com.cskaoyan.springboot.demo.bean.FeedbackExample;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.mapper.FeedbackMapper;
import com.cskaoyan.springboot.demo.service.user.FeedbackService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    FeedbackMapper feedbackMapper;

    @Override
    public PageBean<Feedback> findByCondition(int page, int limit, String username, Integer id, String sort, String order) {
        PageHelper.startPage(page,limit);
        FeedbackExample feedbackExample = new FeedbackExample();
        FeedbackExample.Criteria criteria = feedbackExample.createCriteria();
        if(!("".equals(username)||username==null)){
            criteria = criteria.andUsernameLike("%" + username + "%");
        }
        if(!("".equals(id)||id==null)){
            criteria = criteria.andIdEqualTo(id);
        }
        if(!("".equals(sort)||sort==null)){
            feedbackExample.setOrderByClause(sort + " " + order);
        }
        List<Feedback> feedbacks = feedbackMapper.selectByExample(feedbackExample);
        long total = feedbackMapper.countByExample(feedbackExample);
        return new PageBean<>(feedbacks,total);
    }
}
