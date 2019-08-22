package com.cskaoyan.springboot.demo.bean.wx;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.bean.mall.CategoryLevelOne;
import com.cskaoyan.springboot.demo.bean.wx.category.FloorGoodsData;

import java.util.List;

public class FirstPageData {
    private List<Ad> banner;
    private List<Brand> brandList;
    private List<CategoryLevelOne> channel;
    private List<Coupon> couponList;
    private List<Groupon> grouponList;
    private List<FloorGoodsData> floorGoodsList;
    private List<Goods> hotGoodsList;
    private List<Goods> newGoodsList;
    private List<Topic> topicList;

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

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

    public List<FloorGoodsData> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<FloorGoodsData> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    @Override
    public String toString() {
        return "FirstPageData{" +
                "banner=" + banner +
                ", brandList=" + brandList +
                ", channel=" + channel +
                ", couponList=" + couponList +
                ", grouponList=" + grouponList +
                ", floorGoodsList=" + floorGoodsList +
                ", hotGoodsList=" + hotGoodsList +
                ", newGoodsList=" + newGoodsList +
                ", topicList=" + topicList +
                '}';
    }
}
