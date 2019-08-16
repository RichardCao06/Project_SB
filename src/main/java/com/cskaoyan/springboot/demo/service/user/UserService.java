package com.cskaoyan.springboot.demo.service.user;

import com.cskaoyan.springboot.demo.been.PageBean;
import com.cskaoyan.springboot.demo.been.User;

import java.util.List;

public interface UserService {
    User getById(int id);
    PageBean<User> findByCondition(int page,int rows,String username,String mobile);
}
