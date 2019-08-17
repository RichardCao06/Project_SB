package com.cskaoyan.springboot.demo.service.user;


import com.cskaoyan.springboot.demo.bean.Feedback;
import com.cskaoyan.springboot.demo.bean.PageBean;

public interface FeedbackService {
    PageBean<Feedback> findByCondition(int page, int limit, String username, Integer id, String sort, String order);
}
