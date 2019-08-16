package com.cskaoyan.springboot.demo.service.Impl;


import com.cskaoyan.springboot.demo.bean.ExpressConfig;
import com.cskaoyan.springboot.demo.bean.MallConfig;
import com.cskaoyan.springboot.demo.bean.OrderConfig;
import com.cskaoyan.springboot.demo.bean.WxConfig;
import com.cskaoyan.springboot.demo.mapper.ConfigMapper;
import com.cskaoyan.springboot.demo.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by MatthewLi on 2019/8/16
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigMapper configMapper;

    @Override
    public int configMall(MallConfig mallConfig) {
        return configMapper.configMall(mallConfig);
    }

    @Override
    public int configExpress(ExpressConfig config) {
        return configMapper.configExpress(config);
    }

    @Override
    public int configOrder(OrderConfig config) {
        return configMapper.configOrder(config);
    }

    @Override
    public int configWx(WxConfig config) {
        return configMapper.configWx(config);
    }
}
