package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.systembean.Admin2;
import com.cskaoyan.springboot.demo.bean.systembean.AdminCustom;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.bean.systembean.SystemRole;

import java.util.List;

public interface AdministratorService {
    List<SystemRole> querySysRole();

    List<AdminCustom> queryRoleList(String sort, String desc);

    List<Role> queryAllRoleMsg();

    ResponseVo insertAdmin(Admin2 admin);

    ResponseVo deleteAdmin(int id);

    ResponseVo updateAdmin(Admin2 admin);

    ResponseVo searchByName(String username);

    Admin2 returnByName(String username);
}
