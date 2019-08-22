package com.cskaoyan.springboot.demo.service.popularize.Impl;

import com.cskaoyan.springboot.demo.bean.Coupon;
import com.cskaoyan.springboot.demo.bean.CouponExample;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.CouponMapper;
import com.cskaoyan.springboot.demo.service.popularize.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
  public class CouponServiceImpl implements CouponService {
   @Resource
   CouponMapper couponMapper;
    @Override
     public ResponVo<Coupon> list(String sort,String order,String name, String type, String status, Integer page, Integer limit) {
         PageHelper.startPage(page,limit);
        if (name == null) name = "";
        if (type == null) type = "";
        if (status == null) status = "";
        List<Coupon> list=couponMapper.getList(sort , order ,name , type , status);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(list);
        return  new ResponVo<Coupon>((int)couponPageInfo.getTotal(),list);

        }


    @Override
    public int update(Coupon coupon) {
        /*int i=couponMapper.updateByPrimaryKey(coupon);
        return i;*/
      return   couponMapper.updateByPrimaryKeySelective(coupon);

    }

    @Override
    public void delect(Coupon coupon) {
        couponMapper.deleteByPrimaryKey(coupon.getId());
    }

    @Override
    public void create(Coupon coupon) {
        couponMapper.insert(coupon);
    }

    @Override
    public Coupon queryCouponById(int couponId) {
        return couponMapper.selectByPrimaryKey(couponId);
    }

    @Override
    public Coupon getCouponById(int id) {
        return couponMapper.selectByPrimaryKey(id);

    }


}

