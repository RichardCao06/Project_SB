package com.cskaoyan.springboot.demo.service.popularize;

import com.cskaoyan.springboot.demo.bean.Topic;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;

public interface TopicService {
    int update(Topic ad);
    void delect(Topic ad);
    void create(Topic ad);
    ResponVo list(int page, int limit, String sort, String order, String title, String subtitle);
}
