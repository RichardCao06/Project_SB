package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.CustomResult;
import com.cskaoyan.springboot.demo.mapper.StatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StatServiceImpl implements StatService {
    @Resource
    StatMapper statMapper;
    @Override
    public  List<Map> statUser() {
        return statMapper.statUser();
    }

    @Override
    public List<Map> statOrder() {
        return statMapper.statOrder();
    }

    @Override
    public List<Map> statGoods() {
        return statMapper.statGoods();
    }
}
