package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.CategorySpecific;
import com.cskaoyan.springboot.demo.bean.SpecificItem;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public interface EchoBrandAndCatMapper {

    List<SpecificItem> echoBrand();

    List<CategorySpecific> echoCategory();

    List<SpecificItem> getCatchildrenByPid(String toString);
}
