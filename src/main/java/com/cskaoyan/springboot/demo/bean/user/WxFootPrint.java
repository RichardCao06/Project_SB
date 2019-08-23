package com.cskaoyan.springboot.demo.bean.user;

import java.math.BigDecimal;
import java.util.Date;

public class WxFootPrint {
    private Date addTime;
    private String brief;
    private Integer goodsId;
    private Integer id;
    private String name;
    private String picUrl;
    private BigDecimal retailPrice;

    public WxFootPrint() {
    }

    public WxFootPrint(Date addTime, String brief, Integer goodsId,
                       Integer id, String name, String picUrl, BigDecimal retailPrice) {
        this.addTime = addTime;
        this.brief = brief;
        this.goodsId = goodsId;
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "WxFootPrint{" +
                "addTime=" + addTime +
                ", brief='" + brief + '\'' +
                ", goodsId=" + goodsId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
