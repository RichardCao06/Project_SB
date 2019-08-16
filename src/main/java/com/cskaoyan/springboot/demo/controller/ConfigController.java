package com.cskaoyan.springboot.demo.controller;

/**
 * Created by MatthewLi on 2019/8/16
 */

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.ExpressConfig;
import com.cskaoyan.springboot.demo.bean.MallConfig;
import com.cskaoyan.springboot.demo.bean.OrderConfig;
import com.cskaoyan.springboot.demo.bean.WxConfig;
import com.cskaoyan.springboot.demo.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商场配置admin/config/mall
 * 运费配置admin/config/express
 * 订单配置admin/config/order
 * 小程序配置admin/config/wx
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
        @Autowired
        ConfigService configService;

        @RequestMapping("mall")
        public ResponseVo<MallConfig> configMall(@RequestBody MallConfig config){
            int insert = configService.configMall(config);
            ResponseVo responseVo =new ResponseVo<>();
            responseVo.setData(config);
            ResponseVo response = response(insert, responseVo);
            return response;
        }

    private ResponseVo response(int insert, ResponseVo responseVo) {
        if (insert==1){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            return responseVo;
        }
        if (insert==-1){
            responseVo.setErrmsg("失败");
            responseVo.setErrno(-1);
            return responseVo;
        }
        return responseVo;
    }


    @RequestMapping("/express")
    public ResponseVo<ExpressConfig> configExpress(@RequestBody ExpressConfig expressConfig){
        int insert = configService.configExpress(expressConfig);
        ResponseVo responseVo =new ResponseVo<>();
        responseVo.setData(expressConfig);
        ResponseVo response = response(insert, responseVo);
        return response;
    }

    @RequestMapping("/order")
    public ResponseVo<OrderConfig> configOrder(@RequestBody OrderConfig orderConfig){
        int insert = configService.configOrder(orderConfig);
        ResponseVo responseVo =new ResponseVo<>();
        responseVo.setData(orderConfig);
        ResponseVo response = response(insert, responseVo);
        return response;
    }

    @RequestMapping("/wx")
    public ResponseVo<WxConfig> configWx(@RequestBody WxConfig wxConfig){
        int insert = configService.configWx(wxConfig);
        ResponseVo responseVo =new ResponseVo<>();
        responseVo.setData(wxConfig);
        ResponseVo response = response(insert, responseVo);
        return response;
    }

}
