package com.cskaoyan.springboot.demo.bean.mall;

import com.cskaoyan.springboot.demo.bean.Order;
import com.cskaoyan.springboot.demo.bean.OrderGoods;
import com.cskaoyan.springboot.demo.bean.User;

import java.util.List;

public class OrderData {
    public Order order;
    public List<OrderGoods> orderGoods;
    public User user;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "order=" + order +
                ", orderGoods=" + orderGoods +
                ", user=" + user +
                '}';
    }
}
