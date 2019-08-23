package com.cskaoyan.springboot.demo.controller.wx.order;

import com.cskaoyan.springboot.demo.bean.Cart;
import com.cskaoyan.springboot.demo.bean.Order;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.bean.wx.order.SubmitData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxCheckOrderData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxOrderData;
import com.cskaoyan.springboot.demo.bean.wx.order.WxResponseData;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx")
public class OrderListController {

    @Autowired
    MallService mallService;
    @RequestMapping("order/list")
    public MessageWithData showWxOrderList(int showType, int page, int size){
        MessageWithData messageWithData = new MessageWithData();
        List<WxOrderData> orderDataList = mallService.getWxOrderDataListByShowType(showType,page,size);
        int count = orderDataList.size();
        int totalPages = count / size + 1;

        WxResponseData wxResponseData = new WxResponseData();
        wxResponseData.setCount(count);
        wxResponseData.setData(orderDataList);
        wxResponseData.setTotalPages(totalPages);

        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(wxResponseData);
        return  messageWithData;
    }

 /*@RequestMapping("cart/checkout")
    public MessageWithData checkoutOrder(int cartId, int addressId, int couponId, int grouponRulesId){
        MessageWithData messageWithData = new MessageWithData();
        WxCheckOrderData wxCheckOrderData = mallService.createWxCheckOrder(cartId,addressId,couponId,grouponRulesId);

        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(wxCheckOrderData);
        return messageWithData;
    }


    @RequestMapping("cart/fastadd")
    public MessageWithData fastadd(@RequestBody Cart cart){
        MessageWithData messageWithData = new MessageWithData();
        mallService.WxInsertCart(cart);
        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        return messageWithData;
    }

    @RequestMapping("order/prepay")
    public MessageWithData orderPrepay(@RequestBody Order order){
        MessageWithData messageWithData = new MessageWithData();
        messageWithData.setErrno(724);
        messageWithData.setErrmsg("订单不能支付");
        return messageWithData;
    }

    @RequestMapping("order/submit")
    public MessageWithData orderSubmit(@RequestBody SubmitData submitData){
        MessageWithData messageWithData = new MessageWithData();
        mallService.insertWxOrder(submitData);
        return messageWithData;
    }*/

}
