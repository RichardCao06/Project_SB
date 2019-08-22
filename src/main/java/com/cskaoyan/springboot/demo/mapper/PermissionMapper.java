package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Permission;
import com.cskaoyan.springboot.demo.bean.PermissionExample;
import java.util.List;

import com.cskaoyan.springboot.demo.bean.rolemanage.PerList;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List searchPermission(@Param("roleId")int id);

    List superManage();

    int addPermission(@Param("permission")Permission permission);

    int deleteOldPermission(@Param("roleId")int roleId);

    String searchApi(PerList perList);

    String[] queryPermByIds(String[] ids);
}