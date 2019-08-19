package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.Order;
import com.cskaoyan.springboot.demo.bean.OrderGoods;
import com.cskaoyan.springboot.demo.bean.User;
import com.cskaoyan.springboot.demo.bean.mall.BrandData;
import com.cskaoyan.springboot.demo.bean.mall.BrandMessage;
import com.cskaoyan.springboot.demo.bean.mall.OrderData;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    MallService mallService;


    @RequestMapping("order/list")
    public BrandMessage showOrderListByPage(int page, int limit){
        BrandMessage brandMessage = new BrandMessage();
        BrandData brandData = new BrandData();
        List<Order> orderList =  mallService.findOrderListByPage(page,limit);
        int num = mallService.countOrderList();
        if(orderList != null){
            brandMessage.setErrno(0);
            brandMessage.setErrmsg("成功");
            brandData.setItems(orderList);
            brandData.setTotal(num);
            brandMessage.setData(brandData);
            return brandMessage;
        }
        return null;
    }

    @RequestMapping("order/detail")
    public BrandMessage showOrderListDetailById(int id){
        BrandMessage brandMessage = new BrandMessage();
        OrderData orderData = new OrderData();
        Order order = mallService.findOrderById(id);
        List<OrderGoods> goods = mallService.findOrderGoodsListById(id);
        User user = mallService.findUserByUid(order.getUserId());
        if(order != null){
            brandMessage.setErrno(0);
            brandMessage.setErrmsg("成功");
            orderData.setOrder(order);
            orderData.setOrderGoods(goods);
            orderData.setUser(user);
            brandMessage.setData(orderData);
            return brandMessage;
        }
        return null;
    }
}
