package com.cskaoyan.springboot.demo.mapper.role;

import com.cskaoyan.springboot.demo.bean.rolemanage.Permissions2;
import com.cskaoyan.springboot.demo.bean.rolemanage.Permissions3;
import com.cskaoyan.springboot.demo.bean.rolemanage.RoleLast;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleListMapper {

    List<Permissions2> findTopList(@Param("pid") String pid);
    List<Permissions3> findLabelList(@Param("pid") String pid);
    List<RoleLast> findLastLabel(@Param("pid") String pid);
}
