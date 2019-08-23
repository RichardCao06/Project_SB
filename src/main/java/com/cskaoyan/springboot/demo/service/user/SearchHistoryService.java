package com.cskaoyan.springboot.demo.service.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.SearchHistory;

import java.util.List;

public interface SearchHistoryService {
    PageBean<SearchHistory> findByCondition(int page, int limit,
                                            Integer userId, String keyword, String sort, String order);


    public List<SearchHistory> findALL();
}
