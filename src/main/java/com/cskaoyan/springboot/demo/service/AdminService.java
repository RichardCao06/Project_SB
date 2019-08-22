package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.UserLoginInfo;

public interface AdminService {

    UserLoginInfo queryAdminByUsername(String principal);
}
