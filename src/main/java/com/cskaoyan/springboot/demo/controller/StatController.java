package com.cskaoyan.springboot.demo.controller;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/stat")
public class StatController {

    @Autowired
    StatService statService;

    @RequestMapping("user")
    @ResponseBody
    public  Statistics statUser(){

        Statistics statistics = new Statistics();
        List<Map> statUser =  statService.statUser();
        StatData data = new StatData();
        data.setColumns(new String[]{"day", "users"});
        data.setRows(statUser);
        statistics.setData(data);
        statistics.setErrno(0);
        statistics.setErrmsg("成功");
        return statistics;
    }

    @RequestMapping("order")
    @ResponseBody
    public Statistics statOrder(){
        Statistics statistics = new Statistics();
        List<Map> statOrder = statService.statOrder();
        StatData data = new StatData();
        data.setColumns(new String[]{"day", "orders","customers","amount","pcr"});
        data.setRows(statOrder);
        statistics.setData(data);
        statistics.setErrno(0);
        statistics.setErrmsg("成功");
        return statistics;
    }

    @RequestMapping("goods")
    @ResponseBody
    public Statistics statGoods(){
        Statistics statistics = new Statistics();
        List<Map> statGoods = statService.statGoods();
        StatData data = new StatData();
        data.setColumns(new String[]{"day", "orders","products","amount"});
        data.setRows(statGoods);
        statistics.setData(data);
        statistics.setErrno(0);
        statistics.setErrmsg("成功");
        return statistics;
    }



}
