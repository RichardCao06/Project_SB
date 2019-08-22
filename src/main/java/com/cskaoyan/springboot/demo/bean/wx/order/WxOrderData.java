package com.cskaoyan.springboot.demo.bean.wx.order;

import com.cskaoyan.springboot.demo.bean.OrderGoods;

import java.util.List;

public class WxOrderData {

    private double actualPrice;
    private List<OrderGoods> goodsList;

    private int id;
    private boolean isGroupin;
    private String orderSn;
    private String orderStatusText;

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    @Override
    public String toString() {
        return "WxOrderData{" +
                "actualPrice=" + actualPrice +
                ", goodsList=" + goodsList +
                ", id=" + id +
                ", isGroupin=" + isGroupin +
                ", orderSn='" + orderSn + '\'' +
                ", orderStatusText='" + orderStatusText + '\'' +
                '}';
    }
}
