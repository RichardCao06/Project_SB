package com.cskaoyan.springboot.demo.bean.user;

import java.math.BigDecimal;

public class WxCollect {
    private String brief;
    private Integer id;
    private String name;
    private String picUrl;
    private BigDecimal retailPrice;
    private Byte type;
    private Integer valueId;

    public WxCollect() {
    }

    public WxCollect(String brief, Integer id, String name, String picUrl,
                     BigDecimal retailPrice, Byte type, Integer valueId) {
        this.brief = brief;
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
        this.type = type;
        this.valueId = valueId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    @Override
    public String toString() {
        return "WxCollect{" +
                "brief='" + brief + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", retailPrice=" + retailPrice +
                ", type=" + type +
                ", valueId=" + valueId +
                '}';
    }
}
