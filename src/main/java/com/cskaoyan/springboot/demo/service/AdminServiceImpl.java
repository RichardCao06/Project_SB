package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.*;

import com.cskaoyan.springboot.demo.mapper.AdminMapper;
import com.cskaoyan.springboot.demo.mapper.PermissionMapper;
import com.cskaoyan.springboot.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.System;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public UserLoginInfo queryAdminByUsername(String principal) {
        UserLoginBean admin = adminMapper.queryAdminByUsername(principal);
        int[] ids = admin.getRoleIds();
        Role roles = adminMapper.queryRoleByIds(ids);
        String[] perms = adminMapper.queryPermByIds(ids);
        UserLoginInfo info = new UserLoginInfo();
        info.setName(admin.getUsername());
        info.setAvatar(admin.getAvatar());
        info.setRoles(roles.getName());
        info.setPerms(perms);
        return info;
    }
}
