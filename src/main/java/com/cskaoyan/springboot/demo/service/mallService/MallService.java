package com.cskaoyan.springboot.demo.service.mallService;

import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.Order;
import com.cskaoyan.springboot.demo.bean.OrderGoods;
import com.cskaoyan.springboot.demo.bean.User;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
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

    /**
     * 根据id删除brand数据
     * @param id
     * @return
     */
    int deleteBrandById(Integer id);

    /**
     * 根据id，name搜索brandList数据
     * @param page
     * @param limit
     * @param id
     * @param name
     * @return
     */
    List<Brand> findBrandListByIdByName(int page,int limit,Integer id, String name);

    /**
     * 返回所有的categoryList数据
     * @return
     */
    List<CategoryLevelOne> findCategoryList();

    /**
     * 修改category数据
     * @param categoryLevelOne
     * @return
     */
    int updateCategory(CategoryLevelOne categoryLevelOne);

    /**
     * 查询一级商品类目
     * @return
     */
    List<CategoryData> findLevelOneCategory();

    /**
     * 根据id删除商品类目
     * @param id
     * @return
     */
    int deleteCategoryById(Integer id);

    /**
     * 分页查询orderList
     * @param page
     * @param limit
     * @return
     */
    List<Order> findOrderListByPage(int page, int limit);

    /**
     * 统计order的
     * @return
     */
    int countOrderList();

    /**
     * 根据id查找order
     * @param id
     * @return
     */
    Order findOrderById(int id);

    /**
     * 根据orderId查找orderGoods信息
     * @param id
     * @return
     */
    List<OrderGoods> findOrderGoodsListById(int id);

    /**
     * 根据uid查找用户
     * @param userId
     * @return
     */
    User findUserByUid(Integer userId);
}
