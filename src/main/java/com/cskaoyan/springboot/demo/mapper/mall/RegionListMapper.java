package com.cskaoyan.springboot.demo.mapper.mall;

import com.cskaoyan.springboot.demo.bean.mall.City;
import com.cskaoyan.springboot.demo.bean.mall.County;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionListMapper {
    List<Province> findProvinceList(@Param("type") int type);
    List<City> findCityList(@Param("pid") int pid);
    List<County> findCountyList(@Param("code") String code);
}
