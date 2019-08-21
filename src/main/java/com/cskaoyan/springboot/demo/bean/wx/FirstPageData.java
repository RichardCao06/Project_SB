package com.cskaoyan.springboot.demo.bean.wx;

import com.cskaoyan.springboot.demo.bean.Ad;
import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.Coupon;
import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;

import java.util.List;

public class FirstPageData {
    private List<Ad> banner;
    private List<Brand> brandList;
    private List<CategoryLevelOne> channel;
    private List<Coupon> couponList;
    private List<Groupon> grouponList;




    public List<Ad> getBanner() {
        return banner;
    }

    public void setBanner(List<Ad> banner) {
        this.banner = banner;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<CategoryLevelOne> getChannel() {
        return channel;
    }

    public void setChannel(List<CategoryLevelOne> channel) {
        this.channel = channel;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<Groupon> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<Groupon> grouponList) {
        this.grouponList = grouponList;
    }

    @Override
    public String toString() {
        return "FirstPageData{" +
                "banner=" + banner +
                ", brandList=" + brandList +
                ", channel=" + channel +
                ", couponList=" + couponList +
                ", grouponList=" + grouponList +
                '}';
    }
}
