package com.cskaoyan.springboot.demo.service.mallService.impl;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.mall.CategoryData;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelTwo;
import com.cskaoyan.springboot.demo.bean.mall.Province;
import com.cskaoyan.springboot.demo.bean.wx.category.FloorGoodsData;
import com.cskaoyan.springboot.demo.bean.wx.order.SubmitData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxCheckOrderData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxOrderData;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    CartMapper cartMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;




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


    @Override
    public void WxInsertCart(Cart cart) {
        //1. 更加goodsId查找goods信息
        Integer goodsId = cart.getGoodsId();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        //2. 获取goods的相关信息并放到cart内
        String goodsSn = goods.getGoodsSn();
        cart.setGoodsSn(goodsSn);
        String name = goods.getName();
        cart.setGoodsName(name);
        Short number = cart.getNumber();
        BigDecimal retailPrice = goods.getRetailPrice();
        BigDecimal totalNumber = new BigDecimal(number);
        BigDecimal totalPrice = retailPrice.multiply(totalNumber);
        cart.setPrice(totalPrice);
        System.out.println(cart);
        //3. 将cart数据保存如数据库
        int insert = cartMapper.insert(cart);
        System.out.println(insert);
    }


    @Override
    public WxCheckOrderData createWxCheckOrder(int cartId, int addressId, int couponId, int grouponRulesId) {
        WxCheckOrderData wxCheckOrderData = new WxCheckOrderData();
        //1. 根据cartId获取cart信息
        Cart cart = cartMapper.selectByPrimaryKey(cartId);
        BigDecimal price = cart.getPrice();
        //获取商品总价
        double goodsTotallPrice = price.doubleValue();
        wxCheckOrderData.setGoodsTotalPrice(goodsTotallPrice);
        //保存地址id
        wxCheckOrderData.setAddressId(addressId);
        //2. 根据地址id获取地址数据
        Address address = addressMapper.selectByPrimaryKey(addressId);
        wxCheckOrderData.setCheckAddress(address);
        //3. 获取商品信息
        Integer goodsId = cart.getGoodsId();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        wxCheckOrderData.setCheckGoodsList(goodsList);
        //4. 根据优惠券id查找优惠券信息
        wxCheckOrderData.setCouponId(couponId);
        //Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        //5. 判断是否添加运费,商品价格小于88则加8元运费
        double freightPrice = 0;
        if (goodsTotallPrice < 88){
            freightPrice = 8;
        }
        wxCheckOrderData.setFreightPrice(freightPrice);
        //6.计算订单总价（含运费）
        double actualPrice = goodsTotallPrice + freightPrice;
        wxCheckOrderData.setActuralPrice(actualPrice);
        //7.根据团购id获取团购信息
        wxCheckOrderData.setGrouponRulesId(grouponRulesId);
        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);
        BigDecimal discount = grouponRules.getDiscount();
        double grouponPrice = discount.doubleValue();
        wxCheckOrderData.setGrouponPrice(grouponPrice);
        //8. 计算订单总价，订单总价为实际价格减去团购优惠
        double orderTotalPrice = actualPrice - grouponPrice;
        wxCheckOrderData.setOrderTotalPrice(orderTotalPrice);


        return wxCheckOrderData;
    }

    @Override
    public void insertWxOrder(SubmitData submitData) {
        Order order = new Order();
        //1. 根据addressId获取address信息
        int addressId = submitData.getAddressId();
        Address address = addressMapper.selectByPrimaryKey(addressId);
        String orderAddress = address.getAddress();
        order.setAddress(orderAddress);
        String mobile = address.getMobile();
        order.setMobile(mobile);
        String message = submitData.getMessage();
        order.setMessage(message);
        //储存收件人信息
        String name = address.getName();
        order.setConsignee(name);
        //2. 根据cartId获取cart信息
        int cartId = submitData.getCartId();
        Cart cart = cartMapper.selectByPrimaryKey(cartId);
        BigDecimal goodsprice = cart.getPrice();
        double totalGoodsPrice = goodsprice.doubleValue();
        order.setGoodsPrice(goodsprice);
        //3. 判断是否有运费
        BigDecimal freightPrice = new BigDecimal(0);
        if(totalGoodsPrice < 88){
            freightPrice = new BigDecimal(8);
        }
        order.setFreightPrice(freightPrice);
        //4. 根据couponId获取coupon信息
        BigDecimal couponPrcie = new BigDecimal(0);

        //5. 根据groupId获取groupon信息
        int grouponRulesId = submitData.getGrouponRulesId();
        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);
        BigDecimal discount = grouponRules.getDiscount();
        BigDecimal grouponPrice = goodsprice.subtract(discount);
        order.setGrouponPrice(grouponPrice);

        //6. 计算orderPrice(商品价格减优惠券价格减团购优惠价格）
        BigDecimal orderPrice = goodsprice.subtract(discount).subtract(couponPrcie);
        order.setOrderPrice(orderPrice);
        //7. 计算实际价格actualPrice
        BigDecimal actualPrice = orderPrice.add(freightPrice);
        order.setActualPrice(actualPrice);
        System.out.println(order);
        //8. 将order数据插入数据库
        //orderMapper.insert(order);
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria();
        int i = orderMapper.updateByExampleSelective(order, orderExample);
        System.out.println(i);
    }

    @Override
    public List<WxOrderData> getWxOrderDataList() {

            //1. 获取所有的order
            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria();
            List<Order> orderList = orderMapper.selectByExample(orderExample);
            List<WxOrderData> wxOrderDataList = new ArrayList<>();
            for(Order order:orderList){
                WxOrderData wxOrderData = new WxOrderData();
                BigDecimal actualPrice = order.getActualPrice();
                //1. 获取实际付款
                double wxActualPrice = actualPrice.doubleValue();
                wxOrderData.setActualPrice(wxActualPrice);
                //2. 获取订单id
                Integer id = order.getId();
                wxOrderData.setId(id);
                //3. 根据订单id获取商品
                OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
                orderGoodsExample.createCriteria().andOrderIdEqualTo(id);
                List<OrderGoods> goods = orderGoodsMapper.selectByExample(orderGoodsExample);
                wxOrderData.setGoodsList(goods);
                //4. 获取isGroupIn

                //5. 获取orderSn
                String orderSn = order.getOrderSn();
                wxOrderData.setOrderSn(orderSn);
                //6. 获取orderStatusText
                Short orderStatus = order.getOrderStatus();
                String orderStatusText = orderStatusToText(orderStatus);
                wxOrderData.setOrderStatusText(orderStatusText);
                wxOrderDataList.add(wxOrderData);
            }

        return wxOrderDataList;
    }

    /**
     * 分类展示OrderList
     * @param showType
     * @param page
     * @param size
     * @return
     */
    public List<WxOrderData> getWxOrderDataListByShowType(int showType, int page, int size){
        //1. 获取所有的order
        List<WxOrderData> wxOrderDataList = getWxOrderDataList();
        List<WxOrderData> wxOrderTypeList = new ArrayList<>();
        if(showType == 1){
            for(WxOrderData orderData:wxOrderDataList){
                if(orderData.getOrderStatusText() == "未付款"){
                    wxOrderTypeList.add(orderData);
                }
            }
            return wxOrderTypeList;
        }
        if(showType == 2){
            for(WxOrderData orderData:wxOrderDataList){
                if(orderData.getOrderStatusText() == "已付款"){
                    wxOrderTypeList.add(orderData);
                }
            }
            return wxOrderTypeList;
        }

        if(showType == 3){
            for(WxOrderData orderData:wxOrderDataList){
                if(orderData.getOrderStatusText() == "已发货"){
                    wxOrderTypeList.add(orderData);
                }
            }
            return wxOrderTypeList;
        }

        if(showType == 4){
            for(WxOrderData orderData:wxOrderDataList){
                if(orderData.getOrderStatusText() == "已收货"){
                    wxOrderTypeList.add(orderData);
                }
            }
            return wxOrderTypeList;
        }

        //如果不是以上条件则返回所有的orderlist
        return wxOrderDataList;
    }


    /**
     * 将status数字转换为对应的文本
     * @param orderStatus
     * @return
     */
    public String orderStatusToText(Short orderStatus){
        switch (orderStatus){
            case 101:
                return "未付款";
            case 102:
                return "用户取消";

            case 103:
                return "系统取消";

            case 301:
                return "已发货";

            case 203:
                return "已退款";

            case 457:
                return "申请退款";

            case 201:
                return "已付款";


                default:
                    return null;

        }
    }
}
