package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Coupon;
import com.cskaoyan.springboot.demo.bean.CouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(@RequestBody Coupon record);

    int updateByPrimaryKey(Coupon record);
    List<Coupon> getList(@Param("sort") String sort, @Param("order") String order, @Param("name") String name,
                         @Param("type") String type, @Param("status") String status);

    int create(Coupon coupon);

}