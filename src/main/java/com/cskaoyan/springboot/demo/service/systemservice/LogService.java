package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Log;



public interface LogService {

    ResponseVo insertLog(Log log);

    ResponseVo queryAllLog(int page, int limit);

    ResponseVo searchLog(int page, int limit, String name);

}
