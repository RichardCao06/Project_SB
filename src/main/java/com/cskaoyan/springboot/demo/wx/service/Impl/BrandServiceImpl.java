package com.cskaoyan.springboot.demo.wx.service.Impl;

import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.mapper.BrandMapper;
import com.cskaoyan.springboot.demo.wx.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MatthewLi on 2019/8/22
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

}
