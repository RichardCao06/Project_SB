package com.cskaoyan.springboot.demo.service.popularize.Impl;

import com.cskaoyan.springboot.demo.bean.CouponUser;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.CouponUserMapper;
import com.cskaoyan.springboot.demo.service.popularize.CouponUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class CouponUserServiceImpl implements CouponUserService {
    @Resource
    CouponUserMapper couponUserMapper;
    @Override
    public ResponVo<CouponUser> getListUser(int page, int limit, String sort, String order, int couponId, String userId, String status) {
        PageHelper.startPage(page,limit);
        if (userId == null) userId = "";
        if (status == null) status = "";
        List<CouponUser> list=couponUserMapper.getListUser(sort , order ,couponId , userId , status);
        PageInfo<CouponUser> couponUserPageInfo = new PageInfo<>(list);
        return  new ResponVo<CouponUser>((int)couponUserPageInfo.getTotal(),list);

    }

    @Override
    public CouponUser queryByCouponId(int couponId) {
        return null;
    }

    @Override
    public int insert(Integer userId, int couponId, Date startTime, Date endTime, Date addTime) {
        return 0;
    }

    @Override
    public List<CouponUser> queryByCouponIdList(int couponId) {
        return null;
    }

    @Override
    public List<CouponUser> selectList(int userId) {
        return null;
    }
}
