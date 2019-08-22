package com.cskaoyan.springboot.demo.service.popularize;

import com.cskaoyan.springboot.demo.bean.Coupon;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;



public interface CouponService {
    int update(Coupon coupon);
    void delect(Coupon coupon);
    void create(Coupon coupon);
    Coupon queryCouponById(int couponId);
    Coupon getCouponById(int id);

    ResponVo list(String sort, String order, String name, String type, String status, Integer page, Integer limit);
}

