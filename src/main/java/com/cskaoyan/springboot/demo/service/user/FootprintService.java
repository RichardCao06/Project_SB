package com.cskaoyan.springboot.demo.service.user;


import com.cskaoyan.springboot.demo.bean.Footprint;
import com.cskaoyan.springboot.demo.bean.PageBean;

public interface FootprintService {
    PageBean<Footprint> findByCondition(int page, int limit, Integer userId, Integer goodsId,
                                        String sort, String order);
}
