package com.cskaoyan.springboot.demo.service.mallService.impl;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.Storage;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelTwo;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.bean.wx.category.FloorGoodsData;
import com.cskaoyan.springboot.demo.mapper.*;
import com.cskaoyan.springboot.demo.mapper.mall.BrandListMapper;
import com.cskaoyan.springboot.demo.mapper.mall.CategoryListMapper;
import com.cskaoyan.springboot.demo.mapper.mall.RegionListMapper;
import com.cskaoyan.springboot.demo.mapper.mall.StorageListMapper;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.lang.System;
import java.util.*;

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
    @Autowired
    StorageMapper storageMapper;
    @Autowired
    StorageListMapper storageListMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    AdMapper adMapper;


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


    @Override
    public List<Order> findOrderListByPageByCondition(int page, int limit, short[] orderStatusArray, Integer userId, String orderSn) {
        PageHelper.startPage(page,limit);
        OrderExample orderExample = new OrderExample();
        List<Short> shorts = new ArrayList<>();
        //如果orderStatusArray不为空则将其附加为查询条件
        if(orderStatusArray != null){
            //将short转换为List<Short>
            for (short orderStatus:orderStatusArray){
                shorts.add(orderStatus);
            }
            //将List作为查询条件的参数
            orderExample.createCriteria().andOrderStatusIn(shorts);
        }
        //如果userId不为空则将其附加为查询条件
        if (userId != null){
            orderExample.createCriteria().andUserIdEqualTo(userId);
        }
        //如果orderSn不为空则将其附加为查询条件
        if(orderSn != null){
            orderExample.createCriteria().andOrderSnEqualTo(orderSn);
        }
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }

    @Override
    public int countOrderListByCondition(short[] orderStatusArray, Integer userId, String orderSn) {
        OrderExample orderExample = new OrderExample();
        List<Short> shorts = new ArrayList<>();
        //如果orderStatusArray不为空则将其附加为查询条件
        if(orderStatusArray != null){
            //将short转换为List<Short>
            for (short orderStatus:orderStatusArray){
                shorts.add(orderStatus);
            }
            //将List作为查询条件的参数
            orderExample.createCriteria().andOrderStatusIn(shorts);
        }
        //如果userId不为空则将其附加为查询条件
        if (userId != null){
            orderExample.createCriteria().andUserIdEqualTo(userId);
        }
        //如果orderSn不为空则将其附加为查询条件
        if(orderSn != null){
            orderExample.createCriteria().andOrderSnEqualTo(orderSn);
        }
        int l = (int)orderMapper.countByExample(orderExample);
        return l;
    }

    @Override
    public Storage createUploadFileData(MultipartFile file) {
        Storage storage = new Storage();
        //1.生成addTime
        Date date = new Date();
        storage.setAddTime(date);
        //2.生成文件名key
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();//生成随机的uuid
        String suffix = fileName.substring(fileName.lastIndexOf("."));//截取文件的后缀
        String key = uuid + suffix;
        storage.setKey(key);
        //3.生成原文件的名称
        String name = file.getOriginalFilename();
        storage.setName(name);
        //3.生成文件的大小
        int size = (int)file.getSize();
        storage.setSize(size);
        //4.生成文件的类型
        String type = file.getContentType();
        storage.setType(type);
        //5.生成更新时间
        storage.setUpdateTime(date);
        //6.生成url
        String url = "http://localhost/admin/wx/storage/fetch/" + key;
        storage.setUrl(url);
        return storage;
    }

    @Override
    public int addCategory(Category category) {
        int i = categoryListMapper.insertCategory(category);
        return i;
    }

    @Override
    public void addStorage(Storage storageFile) {
        int i = storageListMapper.insertStorage(storageFile);
    }

    @Override
    public int insertBrand(Brand brand) {
        int i = brandListMapper.insertBrand(brand);
        return i;
    }

    @Override
    public CategoryLevelOne findCategoryById(int id) {
        CategoryLevelOne categoryById = categoryListMapper.findCategoryById(id);
        return categoryById;
    }

    @Override
    public List<FloorGoodsData> findCategoryGoods() {
        List<FloorGoodsData> floorGoodsDataList = new ArrayList<>();

        //1. 获取所有的1级目录
        List<CategoryLevelOne> categoryList = categoryListMapper.findCategoryList("L1");

        //2. 遍历所有的1级目录，获取其id，name，和二级目录
        for(CategoryLevelOne categoryLevelOne:categoryList){
            FloorGoodsData floorGoodsData = new FloorGoodsData();
            floorGoodsData.setId(categoryLevelOne.getId());
            floorGoodsData.setName(categoryLevelOne.getName());
            List<CategoryLevelTwo> categoryLevelTwos = categoryLevelOne.getChildren();
            List<Goods> goodsList = new ArrayList<>();
            //遍历2级类目，并获取对应类目下的所有商品
            for(CategoryLevelTwo categoryLevelTwo:categoryLevelTwos){
                Integer cid = categoryLevelTwo.getId();
                //根据2级类目的id获取对应的商品列表
                GoodsExample goodsExample = new GoodsExample();
                goodsExample.createCriteria().andCategoryIdEqualTo(cid);
                List<Goods> goods = goodsMapper.selectByExample(goodsExample);
                //将查询到的goods到List之中
                for(Goods good:goods){
                    goodsList.add(good);
                }

            }
            floorGoodsData.setGoodsList(goodsList);
            floorGoodsDataList.add(floorGoodsData);

        }

        return floorGoodsDataList;
    }

    @Override
    public List<Goods> findWxHotGoodsListByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIsHotEqualTo(true);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList;
    }

    @Override
    public List<Goods> findWxNewGoodsListByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria().andIsNewEqualTo(true);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList;
    }

    @Override
    public List<Topic> findWxTopicList() {
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria();
        List<Topic> topicList = topicMapper.selectByExample(topicExample);
        return topicList;
    }

    @Override
    public List<Ad> findWxAdList() {
        AdExample adExample = new AdExample();
        adExample.createCriteria();
        List<Ad> ads = adMapper.selectByExample(adExample);
        return ads;
    }
}
