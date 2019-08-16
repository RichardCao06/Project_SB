package com.cskaoyan.springboot.demo.service;


import com.cskaoyan.springboot.demo.bean.CustomResult;

import java.util.List;
import java.util.Map;

public interface StatService {

    List<Map> statUser();
    List<Map> statOrder();
    List<Map> statGoods();


}
