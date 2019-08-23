package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.CategorySpecific;
import com.cskaoyan.springboot.demo.bean.SpecificItem;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public interface EchoBrandAndCatService {
    List<SpecificItem> echoBrand();

    List<CategorySpecific> echoCategory();
}

