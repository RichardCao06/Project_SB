package com.cskaoyan.springboot.demo.wx.service;

import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.wx.bean.CartDelete;
import com.cskaoyan.springboot.demo.wx.bean.Checked;
import com.cskaoyan.springboot.demo.wx.bean.Submit;
import com.cskaoyan.springboot.demo.wx.bean.UpdateMsg;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface CartService {
    ResponseVo queryGoodsCount();

    ResponseVo queryCartList();

    ResponseVo checked(Checked checked);


    Map updateOrder(UpdateMsg updateMsg);

    ResponseVo deleteCartByPid(CartDelete cartDelete);

    ResponseVo addGoods(HttpServletRequest request, Map<String, Object> map);

    Map checkout(Integer cartId, Integer addressId, Integer couponId, Integer grouponRulesId, HttpServletRequest request);

    ResponseVo queryRegionByPid(int pid);

    ResponseVo saveAddress(Address address,Integer userId);

    ResponseVo submitOrder(Submit submit);

    ResponseVo fastAddProduct(Map<String, Object> map);
}
