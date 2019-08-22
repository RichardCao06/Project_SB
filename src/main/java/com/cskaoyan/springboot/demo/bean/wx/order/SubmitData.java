package com.cskaoyan.springboot.demo.bean.wx.order;

public class SubmitData {
    private int addressId;
    private int cartId;
    private int couponId;
    private int grouponLinkId;
    private int grouponRulesId;
    private String message;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getGrouponLinkId() {
        return grouponLinkId;
    }

    public void setGrouponLinkId(int grouponLinkId) {
        this.grouponLinkId = grouponLinkId;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SubmitData{" +
                "addressId=" + addressId +
                ", cartId=" + cartId +
                ", couponId=" + couponId +
                ", grouponLinkId=" + grouponLinkId +
                ", grouponRulesId=" + grouponRulesId +
                ", message='" + message + '\'' +
                '}';
    }
}
