package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Keyword;

import java.util.List;

public interface KeywordService {


    List<Keyword> findKeyword(String keyword, String url, int page, int limit);

    Keyword update(Keyword keyword);

    Keyword insert(Keyword keyword);

    void delete(Keyword keyword);

    public List<Keyword> find_HotKeyword();

    public Keyword get_DefaultKeyword();
}
