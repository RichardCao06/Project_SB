package com.cskaoyan.springboot.demo.service.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.User;

public interface UserService {
    PageBean<User> findByCondition(int page, int rows, String username,
                                   String mobile, String sort, String order);
}
