package com.cskaoyan.springboot.demo.wx.service;

import com.cskaoyan.springboot.demo.bean.System;
import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.mapper.*;
import com.cskaoyan.springboot.demo.realm.UserTokenManager;
import com.cskaoyan.springboot.demo.wx.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    SystemMapper systemMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    RegionMapper regionMapper;



    @Override
    public ResponseVo queryGoodsCount() {
        CartExample example = new CartExample();
        example.createCriteria().andGoodsIdIsNotNull();
        List<Cart> carts = cartMapper.selectByExample(example);
        int size = carts.size();
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(size);
        return responseVo;
    }

    @Override
    public ResponseVo queryCartList() {
        List<CartCustom> carts = cartMapper.cartList();
        ResponseVo<CartIndex> responseVo = new ResponseVo<>();
        CartIndex<CartCustom> cartIndex = new CartIndex<>();
        cartIndex.setCartList(carts);
        CartTotal cartTotal = new CartTotal();
        int checkedGoodsAmount = 0;
        int checkedGoodsCount = 0;
        int goodsAmount = 0;
        int goodsCount = 0;
        //计算价格
        for (CartCustom cart : carts) {
            int price = cart.getPrice().intValue();
            //确认的订单总价和数量
            if (cart.getChecked() == true) {
                checkedGoodsAmount = price * cart.getNumber() + checkedGoodsAmount;
                checkedGoodsCount = cart.getNumber() + checkedGoodsCount;
            }
            goodsAmount = goodsAmount + cart.getNumber() * price;
            goodsCount = goodsCount + cart.getNumber();
        }
        //购物车中的总订单总价和数量
        cartTotal.setCheckedGoodsAmount(checkedGoodsAmount);
        cartTotal.setCheckedGoodsCount(checkedGoodsCount);
        cartTotal.setGoodsAmount(goodsAmount);
        cartTotal.setGoodsCount(goodsCount);

        cartIndex.setCartTotal(cartTotal);
        responseVo.setData(cartIndex);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo checked(Checked checked) {
        //根据订单号去数据库修改订单状态
        for (int productId : checked.getProductIds()) {
            //Cart cart = cartMapper.selectByPid(productId);
            //cart.setChecked(checked.isChecked());
            cartMapper.updateByPid(checked.getIsChecked(),productId);
        }
        return queryCartList();
    }

    //编辑数量
    @Override
    public Map updateOrder(UpdateMsg updateMsg) {
        cartMapper.updateNumById(updateMsg.getNumber(),updateMsg.getId());
        HashMap hashMap = new HashMap();
        hashMap.put("errmsg","成功");
        hashMap.put("errno",0);
        return hashMap;
    }

    @Override
    public ResponseVo deleteCartByPid(CartDelete cartDelete) {
        for (int productId : cartDelete.getProductIds()) {
            cartMapper.deleteByPid(productId);
        }
        return queryCartList();

    }

    @Override
    public ResponseVo addGoods(HttpServletRequest request, Map<String, Object> map) {
        //获取userid
        /*String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);*/

        Cart cart = new Cart();
        //获取传递的json数据
        Integer goodsId = (Integer) map.get("goodsId");
        int number = (int) map.get("number");
        Integer productId = (Integer) map.get("productId");
        cart.setGoodsId(goodsId);
        cart.setNumber((short) number);
        cart.setProductId(productId);
        cart.setChecked(true);
        cart.setAddTime(new Date());

        Double price = goodsProductMapper.queryPriceByGid(goodsId);
        BigDecimal bigDecimal = new BigDecimal(price);
        cart.setPrice(bigDecimal);
        //将goods加入购物车
        cartMapper.insert(cart);
        //并查询该用户购物车内的goods个数
        return queryGoodsCount();
    }

    @Override
    public Map checkout(Integer cartId, Integer addressId, Integer couponId, Integer grouponRulesId, HttpServletRequest request) {
        HashMap hashMap = new HashMap();
        List<CartCustom> carts = cartMapper.cartListCheckedTrue();
        hashMap.put("checkedGoodsList",carts);

        Double goodsTotalPrice=0.0;
        for (CartCustom cart : carts) {
            int price = cart.getPrice().intValue();
            goodsTotalPrice+=price*cart.getNumber();
        }
        hashMap.put("goodsTotalPrice",goodsTotalPrice);
        //地址
        Address address = addressMapper.selectByPrimaryKey(addressId);
        hashMap.put("checkedAddress",address);
        hashMap.put("addressId",addressId);

        //优惠券
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteriaCoupon = couponExample.createCriteria();
        criteriaCoupon.andMinLessThanOrEqualTo(new BigDecimal(goodsTotalPrice))
                .andStatusEqualTo((short)0);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        hashMap.put("availableCouponLength",coupons.size());
        hashMap.put("couponId",couponId);
        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        Double couponPrice=0.0;
        if(coupon!=null){
            couponPrice=coupon.getDiscount().doubleValue();
        }
        hashMap.put("couponPrice",couponPrice);

        //运费
        SystemExample systemExample = new SystemExample();
        SystemExample.Criteria criteriaSys = systemExample.createCriteria();
        criteriaSys.andKeyNameEqualTo("cskaoyan_mall_express_freight_value");
        List<System> systems = systemMapper.selectByExample(systemExample);
        Double keyValue = Double.parseDouble(systems.get(0).getKeyValue());
        hashMap.put("freightPrice",goodsTotalPrice>=88?0.0:keyValue);

        //团购
        hashMap.put("grouponRulesId",grouponRulesId);
        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);
        Double discount=0.0;
        if(grouponRules!=null){

            discount = grouponRules.getDiscount().doubleValue();
        }
       hashMap.put("grouponPrice",discount);

        Double orderTotalPrice=goodsTotalPrice+(goodsTotalPrice>=88?0.0:keyValue)-discount-couponPrice;
        hashMap.put("actualPrice",orderTotalPrice);
        hashMap.put("orderTotalPrice",orderTotalPrice);
        return hashMap;
    }

    @Override
    public ResponseVo queryRegionByPid(int pid) {
        List<Region> regions = regionMapper.queryRegionByPid(pid);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setData(regions);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo saveAddress(Address address,Integer userId) {
        address.setUserId(1);
        address.setAddTime(new Date());
        address.setUpdateTime(new Date());
        addressMapper.insert(address);

        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setData(0);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    @Override
    public ResponseVo submitOrder(Submit submit) {

        return null;
    }

    @Override
    public ResponseVo fastAddProduct(Map<String, Object> map) {

        Cart cart = new Cart();
        //获取传递的json数据
        Integer goodsId = (Integer) map.get("goodsId");
        int number = (int) map.get("number");
        Integer productId = (Integer) map.get("productId");
        cart.setGoodsId(goodsId);
        cart.setNumber((short) number);
        cart.setProductId(productId);
        cart.setChecked(true);
        cart.setAddTime(new Date());

        Double price = goodsProductMapper.queryPriceByGid(goodsId);
        BigDecimal bigDecimal = new BigDecimal(price);
        cart.setPrice(bigDecimal);
        //将goods加入购物车
        cartMapper.insert(cart);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(0);
        return responseVo;
    }


}
