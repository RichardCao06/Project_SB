package com.cskaoyan.springboot.demo.service.mallService;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.bean.wx.category.FloorGoodsData;
import com.cskaoyan.springboot.demo.bean.wx.order.SubmitData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxCheckOrderData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxOrderData;
import org.springframework.web.multipart.MultipartFile;

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
    List<Brand> findBrandListByPage(int page, int limit);

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
    List<Brand> findBrandListByIdByName(int page, int limit, Integer id, String name);

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

    /**
     * 根据条件分页查询order信息
     * @param page
     * @param limit
     * @param orderStatusArray
     * @param userId
     * @param orderSn
     * @return
     */
    List<Order> findOrderListByPageByCondition(int page, int limit, short[] orderStatusArray, Integer userId, String orderSn);

    /**
     * 查询符合条件的order数目
     * @param orderStatusArray
     * @param userId
     * @param orderSn
     * @return
     */
    int countOrderListByCondition(short[] orderStatusArray, Integer userId, String orderSn);

    /**
     * 生成上传文件的相关信息
     * @param file
     * @return
     */
    Storage createUploadFileData(MultipartFile file);

    /**
     * 添加category
     * @param category
     * @return
     */
    int addCategory(Category category);


    /**
     * 将上传的文件信息保存入数据库
     * @param storageFile
     */
    void addStorage(Storage storageFile);

    /**
     * 添加brand数据
     * @param brand
     * @return
     */
    int insertBrand(Brand brand);

    /**
     * 根据id查找商品类目
     * @param id
     * @return
     */
    CategoryLevelOne findCategoryById(int id);

    /**
     * 查找四个1级类目下的全部商品
     * @return
     */
    List<FloorGoodsData> findCategoryGoods();

    /**
     * 查找热门商品
     * @return
     */
    List<Goods> findWxHotGoodsListByPage(int page, int limit);

    /**
     * 查询新品商品
     * @param page
     * @param limit
     * @return
     */
    List<Goods> findWxNewGoodsListByPage(int page, int limit);

    /**
     * 获取话题列表
     * @return
     */
    List<Topic> findWxTopicList();

    /**
     * 获取广告列表
     * @return
     */
    List<Ad> findWxAdList();

    /**
     * 保存订单数据入cart表
     * @param cart
     */
    void WxInsertCart(Cart cart);

    WxCheckOrderData createWxCheckOrder(int cartId, int addressId, int couponId, int grouponRulesId);

    /**
     * 根据提交的信息生成订单
     * @param submitData
     */
    void insertWxOrder(SubmitData submitData);

    /**
     * 获取订单列表
     */
    List<WxOrderData> getWxOrderDataList();

    List<WxOrderData> getWxOrderDataListByShowType(int showType, int page, int size);
}
