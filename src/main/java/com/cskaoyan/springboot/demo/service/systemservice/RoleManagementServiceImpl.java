package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Permission;
import com.cskaoyan.springboot.demo.bean.PermissionExample;
import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.RoleExample;
import com.cskaoyan.springboot.demo.bean.rolemanage.PerList;
import com.cskaoyan.springboot.demo.bean.rolemanage.Permissions1;
import com.cskaoyan.springboot.demo.bean.rolemanage.Permissions2;
import com.cskaoyan.springboot.demo.bean.systembean.Permissions;

import com.cskaoyan.springboot.demo.bean.systembean.SystemRole2;
import com.cskaoyan.springboot.demo.mapper.PermissionMapper;
import com.cskaoyan.springboot.demo.mapper.RoleMapper;
import com.cskaoyan.springboot.demo.mapper.role.RoleListMapper;
import com.cskaoyan.springboot.demo.util.ServiceLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleManagementServiceImpl implements RoleManagementService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleListMapper roleListMapper;
    @Override
    public ResponseVo getRoleManagementList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Role> roles = roleMapper.getAllList();
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        SystemRole2<List<Role>> role2 = new SystemRole2<>();
        role2.setItems(roles);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    @ServiceLog
    public ResponseVo insertRole(Role role) {
        ResponseVo<Object> responseVo = new ResponseVo<>();
        RoleExample example = new RoleExample();
        example.createCriteria().andNameEqualTo(role.getName());

        List<Role> roles = roleMapper.selectByExample(example);
        if (roles.size() != 0) {
            responseVo.setErrmsg("名字已经存在，请重新输入");
            responseVo.setErrno(0);
            return responseVo;
        } else {
            role.setAddTime(new Date());
            role.setUpdateTime(new Date());
            role.setDeleted(true);
            role.setEnabled(true);
            int i = roleMapper.insertSelective(role);

            if (i == 1) {
                responseVo.setErrmsg("成功");
            } else {
                responseVo.setErrmsg("失败");
            }
            responseVo.setErrno(0);
            responseVo.setData(role);
            return responseVo;
        }
    }

    @Override
    public ResponseVo update(Role role) {
        ResponseVo<Object> responseVo = new ResponseVo<>();
        role.setUpdateTime(new Date());
        System.out.println(role.getId());
        int i = roleMapper.updateByPrimaryKey(role);
        if(i == 1){
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
        }
        responseVo.setErrno(0);

        return responseVo;
    }

    @Override
    public ResponseVo delete(Role role) {
        ResponseVo<Object> responseVo = new ResponseVo<>();
        int i = roleMapper.deleteByPrimaryKey(role.getId());
        if(i == 1){
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
        }
        responseVo.setErrno(0);
        return responseVo;
    }

    @Override
    public ResponseVo searchRoleListByName(int page, int limit, String name) {
        PageHelper.startPage(page,limit);
        name = "%" + name + "%";
        List<Role> roles = roleMapper.searchByName(name);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        SystemRole2<List<Role>> role2 = new SystemRole2<>();
        role2.setItems(roles);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo getAssignedPermissions(int id) {
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(id != 1){
            Permissions<Object> permissions = new Permissions<>();
            Permission permission = permissionMapper.selectByPrimaryKey(id);

            responseVo.setData(permission.getPermission());
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            return responseVo;
        }else {
            responseVo.setErrno(0);
            responseVo.setErrmsg("超级管理员权限不能改动");
            return responseVo;
        }

    }
/*授权*/
    @Override
    public ResponseVo permissionsAuth(int roleId) {
        ResponseVo<Permissions1> responseVo = new ResponseVo<>();
            Permissions1<Permissions2> permissions1 = new Permissions1<>();

            List<Permissions2> topList = roleListMapper.findTopList("0");

            permissions1.setSystemPermissions(topList);

            if(roleId != 1){
                List<PerList> list = permissionMapper.searchPermission(roleId);
                permissions1.setAssignedPermissions(list);
            }else {
                List<PerList> list = permissionMapper.superManage();
                permissions1.setAssignedPermissions(list);
            }
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(permissions1);
            return responseVo;




    }

    @Override
    public Map insertPermissionById(int roleId, String[] permissions) {
        HashMap hashMap = new HashMap();
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (roleId != 1) {
            //List oldPermission = permissionMapper.searchPermission(roleId);
            int i = permissionMapper.deleteOldPermission(roleId);
            Permission permission = new Permission();
            for (String s : permissions) {
                permission.setPermission(s);
                permission.setAddTime(new Date());
                permission.setUpdateTime(new Date());
                permission.setDeleted(true);
                permission.setRoleId(roleId);
                permissionMapper.addPermission(permission);
            }
           /* responseVo.setErrno(0);
            responseVo.setErrmsg("成功");*/
            hashMap.put("errno",0);
            hashMap.put("errmsg","成功");
            return hashMap;
        }else {
            /*responseVo.setErrno(0);
            responseVo.setErrmsg("超级管理员权限不能改动");*/
            hashMap.put("errno",641);
            hashMap.put("errmsg","超级管理员权限不能改动");
            return hashMap;
        }
    }
}
