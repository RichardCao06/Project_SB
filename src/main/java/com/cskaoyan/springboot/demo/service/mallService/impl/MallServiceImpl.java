package com.cskaoyan.springboot.demo.service.mallService.impl;

import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.mapper.BrandMapper;
import com.cskaoyan.springboot.demo.mapper.mall.BrandListMapper;
import com.cskaoyan.springboot.demo.mapper.mall.RegionListMapper;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MallServiceImpl implements MallService {

    @Autowired
    RegionListMapper regionListMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    BrandListMapper brandListMapper;
    @Override
    public List<Province> findRegionList() {
        List<Province> provinceList = regionListMapper.findProvinceList(1);
        return provinceList;
    }

    @Override
    public List<Brand> findBrandListByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Brand> brandList = brandListMapper.findAllBrandList();
        return brandList;
    }

    @Override
    public int countBrandList() {
        int count = brandListMapper.countBrandList();
        return count;
    }

    @Override
    public int updateBrand(Brand brand) {
        int i = brandListMapper.updateBrand(brand);
        return i;
    }

    @Override
    public Brand findBrandById(Integer id) {
        Brand brand = brandListMapper.findBrandById(id);
        return brand;
    }
}
