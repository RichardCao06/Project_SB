package com.cskaoyan.springboot.demo.service.popularize;

import com.cskaoyan.springboot.demo.bean.CouponUser;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;

import java.util.Date;
import java.util.List;

public interface CouponUserService {
    ResponVo<CouponUser> getListUser(int page, int limit, String sort, String order, int couponId, String userId, String status);

    CouponUser queryByCouponId(int couponId);

    int insert(Integer userId, int couponId, Date startTime, Date endTime, Date addTime);

    List<CouponUser> queryByCouponIdList(int couponId);

    List<CouponUser> selectList(int userId);
}
