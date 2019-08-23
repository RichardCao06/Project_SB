package com.cskaoyan.springboot.demo.bean.wx.search;

import com.cskaoyan.springboot.demo.bean.Keyword;
import com.cskaoyan.springboot.demo.bean.SearchHistory;

import java.util.List;

public class Dataz {
    private Keyword defaultKeyword;
    private List<Keyword>  hotKeywordList;
    private List<SearchHistory> searchHistoryList;

    public Keyword getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(Keyword defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<Keyword> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<Keyword> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }

    public List<SearchHistory> getSearchHistoryList() {
        return searchHistoryList;
    }

    public void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
        this.searchHistoryList = searchHistoryList;
    }

    @Override
    public String toString() {
        return "Dataz{" +
                "defaultKeyword=" + defaultKeyword +
                ", hotKeywordList=" + hotKeywordList +
                ", searchHistoryList=" + searchHistoryList +
                '}';
    }
}
