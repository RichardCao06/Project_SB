package com.cskaoyan.springboot.demo.service.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.Collect;

public interface CollectService {
    PageBean<Collect> findByCondition(int page, int limit, Integer userId,
                                      Integer valueId, String sort, String order);
}
