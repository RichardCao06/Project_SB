package com.cskaoyan.springboot.demo.service.user.impl;

import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.User;
import com.cskaoyan.springboot.demo.bean.UserExample;
import com.cskaoyan.springboot.demo.mapper.UserMapper;
import com.cskaoyan.springboot.demo.service.user.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    public User getById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean<User> findByCondition(int page,int rows,String username, String mobile) {
        PageHelper.startPage(page,rows);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(!("".equals(username)||username==null)){
            criteria = criteria.andUsernameLike("%" + username + "%");
        }
        if(!("".equals(mobile)||mobile==null)){
            criteria = criteria.andMobileEqualTo(mobile);
        }
        List<User> users = userMapper.selectByExample(userExample);
        //long total = new PageInfo<>(users).getTotal();
        long total = userMapper.countByExample(userExample);
        return new PageBean<User>(users,total);
    }
}
