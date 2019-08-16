package com.cskaoyan.springboot.demo.mapper;



import java.util.List;
import java.util.Map;

public interface StatMapper {

    List<Map> statUser();
    List<Map> statOrder();
    List<Map> statGoods();

}
