package com.cskaoyan.springboot.demo.service.mallService;

import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.mall.Province;

import java.util.List;

public interface MallService {
    /**
     * 获取所有的行政区域
     * @return
     */
    List<Province> findRegionList();

    /**
     * 获取品牌制造商的数据
     * @param page
     * @param limit
     * @return
     */
    List<Brand> findBrandListByPage(int page,int limit);

    /**
     * 查找Brand的总数
     * @return
     */
    int countBrandList();

    /**
     * 根据传入的brand参数修改原brand的数据
     * @param brand
     * @return
     */
    int updateBrand(Brand brand);

    /**
     * 根据id查找Brand数据
     * @param id
     * @return
     */
    Brand findBrandById(Integer id);
}
