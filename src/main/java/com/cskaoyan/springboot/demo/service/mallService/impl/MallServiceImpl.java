package com.cskaoyan.springboot.demo.service.mallService.impl;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.mapper.BrandMapper;
import com.cskaoyan.springboot.demo.mapper.OrderGoodsMapper;
import com.cskaoyan.springboot.demo.mapper.OrderMapper;
import com.cskaoyan.springboot.demo.mapper.UserMapper;
import com.cskaoyan.springboot.demo.mapper.mall.BrandListMapper;
import com.cskaoyan.springboot.demo.mapper.mall.CategoryListMapper;
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
    @Autowired
    CategoryListMapper categoryListMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    UserMapper userMapper;


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

    @Override
    public int deleteBrandById(Integer id) {
        int i = brandListMapper.deleteBrandById(id);
        return i;
    }

    @Override
    public List<Brand> findBrandListByIdByName(int page, int limit, Integer id, String name) {
        PageHelper.startPage(page,limit);
        //对查询条件name拼接上%，以便执行模糊查询
        if(name != null) {
            name = "%" + name + "%";
        }
        List<Brand> brandList = brandListMapper.findBrandListByIdByName(id, name);
        return brandList;
    }

    @Override
    public List<CategoryLevelOne> findCategoryList() {
        List<CategoryLevelOne> list = categoryListMapper.findCategoryList("L1");
        return list;
    }


    @Override
    public int updateCategory(CategoryLevelOne categoryLevelOne) {
        int i = categoryListMapper.updateCategory(categoryLevelOne);
        return i;
    }

    @Override
    public List<CategoryData> findLevelOneCategory() {
        List<CategoryData> l1 = categoryListMapper.findLevelOneCategoryList("L1");
        return l1;
    }

    @Override
    public int deleteCategoryById(Integer id) {
        int i = categoryListMapper.deleteCategory(id);
        return i;
    }

    @Override
    public List<Order> findOrderListByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria();
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }

    @Override
    public int countOrderList() {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria();
        int num = (int)orderMapper.countByExample(orderExample);
        return num;
    }


    @Override
    public Order findOrderById(int id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

    @Override
    public List<OrderGoods> findOrderGoodsListById(int id) {
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        orderGoodsExample.createCriteria().andOrderIdEqualTo(id);
        List<OrderGoods> goods = orderGoodsMapper.selectByExample(orderGoodsExample);
        return goods;
    }

    @Override
    public User findUserByUid(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
