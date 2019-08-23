package com.cskaoyan.springboot.demo.controller.wx;


import com.cskaoyan.springboot.demo.bean.Keyword;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.SearchHistory;
import com.cskaoyan.springboot.demo.bean.wx.search.Dataz;
import com.cskaoyan.springboot.demo.bean.wx.search.Errno;
import com.cskaoyan.springboot.demo.service.KeywordServiceImpl;
import com.cskaoyan.springboot.demo.service.user.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx")
public class SearchController {

    @Autowired
    KeywordServiceImpl keywordService;

    @Autowired
    SearchHistoryService searchHistoryService;


    @RequestMapping("search/index")
    public Errno search_HotKeywords(){
        Errno errno = new Errno();
        PageBean<SearchHistory> searchHistoryPageBean = searchHistoryService.findByCondition(1, 10, 0, null,null,null);
        List<SearchHistory> searchHistoryList = searchHistoryPageBean.getItems();
        //List<SearchHistory> searchHistoryList= searchHistoryService.findALL();

        Keyword defaultKeyword = keywordService.get_DefaultKeyword();

        List<Keyword> hotKeywordList = keywordService.find_HotKeyword();
        Dataz dataz = new Dataz();

        dataz.setDefaultKeyword(defaultKeyword);
        dataz.setHotKeywordList(hotKeywordList);
        dataz.setSearchHistoryList(searchHistoryList);

        errno.setErrmsg("成功");
        errno.setErrno(0);
        errno.setData(dataz);

        return errno;

    }




}
