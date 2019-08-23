package com.cskaoyan.springboot.demo.controller.popularize;

import com.cskaoyan.springboot.demo.bean.Coupon;
import com.cskaoyan.springboot.demo.bean.CouponUser;
import com.cskaoyan.springboot.demo.bean.popularize.Errmsg;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.service.popularize.CouponService;
import com.cskaoyan.springboot.demo.service.popularize.CouponUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class CouponController {
    @Autowired
    CouponService couponService;
    @Autowired
    CouponUserService couponUserService;
    @RequestMapping("/coupon/list")
    @ResponseBody
    public  Map<String,Object> list(String sort, String order, String name, String type,String stauts, Integer page,Integer limit){
        ResponVo<Coupon> couponResponVo=couponService.list(sort,order,name,type,stauts,page,limit);
        Map<String, Object> map = new HashMap<>();
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", couponResponVo);
        return  map;
        /*new Errmsg(couponResponVo,"成功",0);*/
    }

    @RequestMapping("coupon/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Coupon coupon) {
        Map<String, Object> map = new HashMap<>();
        couponService.update(coupon);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", coupon);
        return map;
    }
    @ResponseBody
    @RequestMapping("coupon/create")
    public Map<String,Object> create(@RequestBody Coupon coupon){
        Map<String, Object> map = new HashMap<>();
        couponService.create(coupon);
        map.put("errno",0);
        map.put("errmsg","成功");
        map.put("data",coupon);
        return map;
    }
/*http://localhost/admin/coupon/listuser?page=1&limit=20&couponId=14&sort=add_time&order=desc
Request Method: GET*/
     @RequestMapping("coupon/listuser")
     @ResponseBody
     public Map<String,Object> listuser(int page, int limit, int couponId , String userId ,String sort, String order, String status){
         ResponVo<CouponUser> couponUserResponVo=couponUserService.getListUser(page, limit, sort, order, couponId, userId, status);
         Map<String, Object> map = new HashMap<>();
         map.put("errmsg", "成功");
         map.put("errno", 0);
         map.put("data", couponUserResponVo);
         return  map;
     }
    /* http://localhost:8080/admin/coupon/read?id=9*/
    @RequestMapping("coupon/read")
    @ResponseBody
    public Map<String,Object> read(int id) { Map<String, Object> map = new HashMap<>();

        Coupon coupon = couponService.getCouponById(id);
        map.put("errno", 0);
        map.put("errmsg", "成功");
        map.put("data", coupon);
        return map;
    }

    @RequestMapping("coupon/delete")
    @ResponseBody
    public Map<String,Object> delete(@RequestBody Coupon coupon){
        Map<String, Object> map = new HashMap<>();
        couponService.delect(coupon);
        map.put("errno",0);
        map.put("errmsg","成功");
        return map;
    }
    /*public Map<String,Object> xxx(String name,short type,short stauts, Integer page,Integer limit){
        HashMap<String,Object> map=new HashMap<>();
        map.put("errmsg","成功");
        map.put("errno",0);
        if(name==null&&"".equals(type)&&"".equals(stauts)){
            ResponVo<Coupon> adResponVo=couponService.findAll(page, limit);
            map.put("data",adResponVo);
            return map;
        }
        else{
            ResponVo<Coupon> adResponVo=couponService.list(name,type,stauts,page,limit);
            map.put("data",adResponVo);
            return map;
        }
    }*/
}
