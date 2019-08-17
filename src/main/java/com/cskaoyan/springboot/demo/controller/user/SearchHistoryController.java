package com.cskaoyan.springboot.demo.controller.user;


import com.cskaoyan.springboot.demo.bean.Errno;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.SearchHistory;
import com.cskaoyan.springboot.demo.service.user.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("history")
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;

    @RequestMapping("list")
    public Object list(int page,int limit,Integer userId,String keyword,String sort,String order){
        PageBean<SearchHistory> searchHistories = searchHistoryService.findByCondition(page, limit, userId, keyword, sort, order);
        return new Errno<SearchHistory>(searchHistories,"成功",0);
    }
}
