package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Role;


import java.util.Map;

public interface RoleManagementService {
    ResponseVo getRoleManagementList(int page, int limit);

    ResponseVo insertRole(Role role);

    ResponseVo update(Role role);

    ResponseVo delete(Role role);

    ResponseVo searchRoleListByName(int page, int limit, String name);

    ResponseVo getAssignedPermissions(int id);

    ResponseVo permissionsAuth(int id);

    Map insertPermissionById(int roleId, String[] permissions);




}
