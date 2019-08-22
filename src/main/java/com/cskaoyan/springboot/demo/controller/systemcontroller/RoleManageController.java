package com.cskaoyan.springboot.demo.controller.systemcontroller;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.rolemanage.*;

import com.cskaoyan.springboot.demo.service.systemservice.RoleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin")
public class RoleManageController {
    @Autowired
    RoleManagementService roleManagementService;

    @RequestMapping("role/list")
    public ResponseVo rolelist(int page, int limit, String sort, String order, String name){
        if(name!=null){
            return roleManagementService.searchRoleListByName(page,limit,name);
        }
        return roleManagementService.getRoleManagementList(page,limit);
    }

    @RequestMapping("role/create")
    public ResponseVo roleCreat(@RequestBody Role role){
        return roleManagementService.insertRole(role);
    }

    @RequestMapping("role/update")
    public ResponseVo updateRole(@RequestBody Role role){
        return roleManagementService.update(role);
    }

    @RequestMapping("role/delete")
    public ResponseVo deleteRole(@RequestBody Role role){
        return roleManagementService.delete(role);
    }

    @RequestMapping("role/permissions")
    public ResponseVo permit(int roleId){
        return roleManagementService.permissionsAuth(roleId);
    }

    @PostMapping("role/permissions")
    public Map addPer(@RequestBody PermissionRoleId permissionRoleId){
        return roleManagementService.insertPermissionById(permissionRoleId.getRoleId(),permissionRoleId.getPermissions());
    }



}
