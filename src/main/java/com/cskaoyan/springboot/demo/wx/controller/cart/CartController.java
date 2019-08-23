package com.cskaoyan.springboot.demo.wx.controller.cart;



import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;

import com.cskaoyan.springboot.demo.wx.bean.CartDelete;
import com.cskaoyan.springboot.demo.wx.bean.Checked;
import com.cskaoyan.springboot.demo.wx.bean.Submit;
import com.cskaoyan.springboot.demo.wx.bean.UpdateMsg;
import com.cskaoyan.springboot.demo.wx.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("wx")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("cart/index")
    public ResponseVo cartList(){
        return cartService.queryCartList();
    }

    @RequestMapping("cart/goodscount")
    public ResponseVo goodsCount(){
        return cartService.queryGoodsCount();
    }

    @RequestMapping("cart/checked")
    public ResponseVo check(@RequestBody Checked checked){
        return cartService.checked(checked);
    }

    @RequestMapping("cart/update")
    public Map update(@RequestBody UpdateMsg updateMsg){
        return cartService.updateOrder(updateMsg);
    }

    @RequestMapping("cart/delete")
    public ResponseVo delete(@RequestBody CartDelete cartDelete){
        return cartService.deleteCartByPid(cartDelete);
    }

    @RequestMapping("cart/add")
    public ResponseVo cartAdd(HttpServletRequest request, @RequestBody Map<String,Object> map){
      return cartService.addGoods(request,map);
    }

    @RequestMapping("cart/checkout")
    public Map cartCheck(Integer cartId, Integer addressId, Integer couponId, Integer grouponRulesId, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        Map data = cartService.checkout(cartId, addressId, couponId, grouponRulesId,request);
        map.put("data",data);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("region/list")
    public ResponseVo regionList(int pid){
        return cartService.queryRegionByPid(pid);
    }

    @RequestMapping("order/submit")
    public ResponseVo submit(@RequestBody Submit submit){
        return cartService.submitOrder(submit);
    }

    @RequestMapping("cart/fastadd")
    public ResponseVo fastAdd(@RequestBody Map<String,Object> map){
        return cartService.fastAddProduct(map);
    }

    /*@RequestMapping("address/save")
    public ResponseVo addSave(@RequestBody Address address,HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        return cartService.saveAddress(address,userId);
    }*/
}
