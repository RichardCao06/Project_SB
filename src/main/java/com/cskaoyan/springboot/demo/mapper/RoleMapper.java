package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.RoleExample;

import java.util.List;

import com.cskaoyan.springboot.demo.bean.systembean.SystemRole;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /*查询管理员信息*/
    List<SystemRole> queryRoleIdAndName();
}