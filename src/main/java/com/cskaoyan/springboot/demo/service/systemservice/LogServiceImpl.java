package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Log;
import com.cskaoyan.springboot.demo.bean.LogExample;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.bean.systembean.SystemRole2;
import com.cskaoyan.springboot.demo.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public ResponseVo insertLog(Log log) {
        int insert = logMapper.insert(log);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        responseVo.setData(log);
        return responseVo;
    }

    @Override
    public ResponseVo queryAllLog() {
        LogExample example = new LogExample();
        example.createCriteria().andActionIsNotNull();
        List<Log> logs = logMapper.selectByExample(example);
        SystemRole2<List<Log>> role2 = new SystemRole2<>();
        role2.setItems(logs);
        role2.setTotal(logs.size());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;

    }
}
