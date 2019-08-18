package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Log;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;

public interface LogService {

    ResponseVo insertLog(Log log);

    ResponseVo queryAllLog();
}
