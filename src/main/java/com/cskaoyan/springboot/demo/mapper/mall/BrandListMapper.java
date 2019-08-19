package com.cskaoyan.springboot.demo.mapper.mall;

import com.cskaoyan.springboot.demo.bean.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandListMapper {
    List<Brand> findAllBrandList();
    int countBrandList();

    int updateBrand(@Param("brand") Brand brand);

    Brand findBrandById(@Param("id") int id);

    int deleteBrandById(@Param("id") int id);

    List<Brand> findBrandListByIdByName(@Param("id")Integer id,@Param("name") String name);
}
