package com.cskaoyan.springboot.demo.controller.wx;

import com.cskaoyan.springboot.demo.bean.popularize.DataVo;
import org.springframework.stereotype.Controller;
import com.cskaoyan.springboot.demo.bean.Coupon;
import com.cskaoyan.springboot.demo.bean.CouponExample;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.CouponMapper;
import com.cskaoyan.springboot.demo.service.popularize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WxCouponController {
    @Autowired
    CouponService couponService;
    @Resource
    CouponMapper couponMapper;
    //  :8081/wx/coupon/mylist?status=0&page=1&size=10
    //个人中心优惠券
    @RequestMapping("wx/coupon/mylist")
    @ResponseBody
    public Map<String,Object> mylist(int status, int page, int size){
        Map<String,Object> map=new HashMap<>();

        DataVo<Coupon>  couponDataVo=couponService.getCouponByStatus(status,page,size);
        map.put("errno",0);
        map.put("errmsg","成功");
        map.put("data",couponDataVo);
        return map;

    }
    //     exchange 优惠券兑换码=cskaoyan_mall_coupon.code
    @RequestMapping("wx/coupon/exchange")
    @ResponseBody
    public Map<String,Object> exchange(@RequestBody String code){
        Map<String,Object> map=new HashMap<>();
//        CouponExample couponExample=new CouponExample();
//        couponExample.createCriteria().andCodeEqualTo(code);
       // List<Coupon> list=couponMapper.selectByExample(couponExample);

      //  DataVo<Coupon> couponResponVo=new DataVo<>(list.size(),list);
        map.put("errno",0);
        map.put("errmsg","成功");
      //  map.put("data",couponResponVo);
        return map;

    }

}
