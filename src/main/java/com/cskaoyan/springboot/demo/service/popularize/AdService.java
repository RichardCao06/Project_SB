package com.cskaoyan.springboot.demo.service.popularize;

import com.cskaoyan.springboot.demo.bean.Ad;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;

import java.util.Map;

public interface AdService {

    int update(Ad ad);
    void delect(Ad ad);
    void create(Ad ad);
    ResponVo list(String name, String content, Integer page, Integer limit);
}
