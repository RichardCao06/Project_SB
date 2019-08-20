package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Admin;
import com.cskaoyan.springboot.demo.bean.AdminExample;
import java.util.List;

import com.cskaoyan.springboot.demo.bean.AdminVo;
import com.cskaoyan.springboot.demo.bean.systembean.Admin2;
import com.cskaoyan.springboot.demo.bean.systembean.AdminCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin2 record);

    /*查询RoleList信息*/
    List<AdminCustom> queryRoleList();

    int creatAdmin(@Param("admin") Admin2 admin);

    List<AdminCustom> searchByName(@Param("username") String username);

    Admin2 returnByName(@Param("username")String username);


    @Select("select password from cskaoyan_mall_admin where username = #{username}")
    String queryPasswordByUserName(@Param("username") String username);

     @Select("select p.permission from cskaoyan_mall_admin a LEFT JOIN cskaoyan_mall_permission p on a.role_ids = p.role_id  where a.username = #{username}")
    List<String> queryPermissionsByUserName(@Param("username") String username);

    @Select("select DISTINCT a.avatar, r.name from cskaoyan_mall_admin a LEFT JOIN cskaoyan_mall_permission p on  a.role_ids = p.role_id LEFT JOIN cskaoyan_mall_role r on  a.role_ids = r.id  where username = #{username}")
    AdminVo queryAdmin(@Param("username") String username);


}