package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Cart;
import com.cskaoyan.springboot.demo.bean.CartExample;
import java.util.List;

import com.cskaoyan.springboot.demo.wx.bean.CartCustom;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);


    //查询所有cart信息
    List<CartCustom> cartList();

    Cart selectByPid(@Param("pid") int pid);

    int updateByPid(@Param("checked")int checked,@Param("pid")int pid);

    int updateNumById(@Param("number")int num,@Param("id")int id);

    int deleteByPid(@Param("pid")int pid);

    List<CartCustom> cartListCheckedTrue();
}