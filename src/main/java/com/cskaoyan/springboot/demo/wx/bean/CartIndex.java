package com.cskaoyan.springboot.demo.wx.bean;

import java.util.List;

public class CartIndex<T> {
    List<T> cartList;
    CartTotal cartTotal;

    public List<T> getCartList() {
        return cartList;
    }

    public void setCartList(List<T> cartList) {
        this.cartList = cartList;
    }

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }
}
