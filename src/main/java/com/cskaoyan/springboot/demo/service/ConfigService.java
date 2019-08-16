package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.ExpressConfig;
import com.cskaoyan.springboot.demo.bean.MallConfig;
import com.cskaoyan.springboot.demo.bean.OrderConfig;
import com.cskaoyan.springboot.demo.bean.WxConfig;

/**
 * Created by MatthewLi on 2019/8/16
 */
public interface ConfigService {

    int configMall(MallConfig mallConfig);

    int configExpress(ExpressConfig config);

    int configOrder(OrderConfig orderConfig);

    int configWx(WxConfig wxConfig);
}
