package com.cskaoyan.springboot.demo.bean.wx.order;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.Goods;


import java.util.List;

public class WxCheckOrderData {
    private double acturalPrice;
    private int addressId;
    private int availableCouponLength;
    private Address checkAddress;
    private List<Goods> checkGoodsList;
    private int couponId;
    private double couponPrice;
    private double freightPrice;
    private double goodsTotalPrice;
    private double grouponPrice;
    private int grouponRulesId;
    private double orderTotalPrice;

    public double getActuralPrice() {
        return acturalPrice;
    }

    public void setActuralPrice(double acturalPrice) {
        this.acturalPrice = acturalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public Address getCheckAddress() {
        return checkAddress;
    }

    public void setCheckAddress(Address checkAddress) {
        this.checkAddress = checkAddress;
    }

    public List<Goods> getCheckGoodsList() {
        return checkGoodsList;
    }

    public void setCheckGoodsList(List<Goods> checkGoodsList) {
        this.checkGoodsList = checkGoodsList;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    @Override
    public String toString() {
        return "WxCheckOrderData{" +
                "acturalPrice=" + acturalPrice +
                ", addressId=" + addressId +
                ", availableCouponLength=" + availableCouponLength +
                ", checkAddress=" + checkAddress +
                ", checkGoodsList=" + checkGoodsList +
                ", couponId=" + couponId +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", goodsTotalPrice=" + goodsTotalPrice +
                ", grouponPrice=" + grouponPrice +
                ", grouponRulesId=" + grouponRulesId +
                ", orderTotalPrice=" + orderTotalPrice +
                '}';
    }
}
