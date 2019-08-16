/*
package com.cskaoyan.springboot.demo;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.mall.City;
import com.cskaoyan.springboot.demo.bean.mall.County;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.mapper.AdMapper;
import com.cskaoyan.springboot.demo.mapper.BrandMapper;
import com.cskaoyan.springboot.demo.mapper.mall.BrandListMapper;
import com.cskaoyan.springboot.demo.mapper.mall.RegionListMapper;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.System;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.cskaoyan.springboot.demo.mapper")
public class DemoApplicationTests {
    @Autowired
    AdMapper adMapper;
    @Autowired
    RegionListMapper regionListMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    MallService mallService;
    @Autowired
    BrandListMapper brandListMapper;

    @Test
    public void contextLoads() {
        AdExample adExample = new AdExample();
        adExample.createCriteria();
        List<Ad> ads = adMapper.selectByExample(adExample);
        System.out.println(ads);
    }

    @Test
    public void regionListMapperTest(){
        List<Province> provinceList = regionListMapper.findProvinceList(1);
        System.out.println(provinceList);
        for (Province province:provinceList){
            System.out.println(province);
            for(City city:province.getChildren()){
                System.out.println(city);
                for(County county:city.getChildren()){
                    System.out.println(county);
                }
            }
        }
    }

    @Test
    public void brandMapperTest(){
        List<Brand> brandListByPage = mallService.findBrandListByPage(1, 1);
        System.out.println(brandListByPage);
    }

    @Test
    public void brandExampleTest(){
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria();
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        System.out.println(brands);
    }

    @Test
    public void brandListMapperTest(){
        List<Brand> allBrandList = brandListMapper.findAllBrandList();
        System.out.println(allBrandList);
    }

    @Test
    public void testCount(){
        int i = brandListMapper.countBrandList();
        System.out.println(i);
    }

    @Test
    public void testPageHelper(){
        List<Brand> brandListByPage = mallService.findBrandListByPage(2, 3);
        System.out.println(brandListByPage);
        for (Brand brand:brandListByPage){
            System.out.println(brand);
        }
    }

    @Test
    public void testUpdate(){
        Brand brand = new Brand();
        brand.setId(1001000);
        brand.setDesc("测试");
        brand.setName("测试");
        brand.setPicUrl("测试");
        brand.setFloorPrice(BigDecimal.valueOf(11.11));
        int i = brandListMapper.updateBrand(brand);
        System.out.println(i);
    }

    @Test
    public void testFindBrandById(){
        Brand brand = brandListMapper.findBrandById(1001000);
        System.out.println(brand);
    }

}
*/
