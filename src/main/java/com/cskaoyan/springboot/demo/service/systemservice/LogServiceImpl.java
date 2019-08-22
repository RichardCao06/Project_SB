package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Log;
import com.cskaoyan.springboot.demo.bean.LogExample;

import com.cskaoyan.springboot.demo.bean.systembean.SystemRole2;
import com.cskaoyan.springboot.demo.mapper.LogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public ResponseVo queryAllLog(int page,int limit) {
        PageHelper.startPage(page,limit);
        LogExample example = new LogExample();
        example.createCriteria().andActionIsNotNull();
        List<Log> logs = logMapper.selectByExample(example);
        PageInfo<Log> pageInfo = new PageInfo<>(logs);
        SystemRole2<List<Log>> role2 = new SystemRole2<>();
        role2.setItems(logs);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;

    }

    @Override
    public ResponseVo searchLog(int page,int limit,String name) {
        PageHelper.startPage(page,limit);
        name = "%" + name + "%";
        List<Log> logs = logMapper.searchLogByName(name);
        PageInfo<Log> pageInfo = new PageInfo<>(logs);
        SystemRole2 role2 = new SystemRole2();
        role2.setItems(logs);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }
}
