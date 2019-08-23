package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.bean.CategorySpecific;
import com.cskaoyan.springboot.demo.bean.SpecificItem;
import com.cskaoyan.springboot.demo.mapper.EchoBrandAndCatMapper;
import com.cskaoyan.springboot.demo.service.EchoBrandAndCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
@Service
public class EchoBrandAndCatServiceImpl implements EchoBrandAndCatService {

    @Autowired
    EchoBrandAndCatMapper echoBrandAndCatMapper;

    @Override
    public List<SpecificItem> echoBrand() {
        return echoBrandAndCatMapper.echoBrand();
    }

    @Override
    public List<CategorySpecific> echoCategory() {
        List<CategorySpecific> categorySpecifics = echoBrandAndCatMapper.echoCategory();
        for (CategorySpecific categorySpecific : categorySpecifics) {
            int pid = categorySpecific.getValue();
            List<SpecificItem> catchildrenByPid = echoBrandAndCatMapper.getCatchildrenByPid(Integer.toString(pid));
            categorySpecific.setChildren(catchildrenByPid);
        }
        return categorySpecifics;
    }
}

