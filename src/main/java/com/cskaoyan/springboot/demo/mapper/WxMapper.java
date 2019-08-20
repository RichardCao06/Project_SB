package com.cskaoyan.springboot.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WxMapper {

    @Select("select password from cskaoyan_mall_user where username = #{username}")
    String queryPasswordByUserName(@Param("username") String username);
}
