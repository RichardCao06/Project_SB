/*
package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.GrouponExample;
import java.util.List;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.GoodsAndGrouponAndGrouponRules;
import org.apache.ibatis.annotations.Param;

public interface GrouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groupon record);

    int insertSelective(Groupon record);

    Groupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);

    List<Groupon> getListRecord(@Param("sort") String sort, @Param("order") String order,
                                @Param("goodsId") String goodsId);
    int create(GrouponRules grouponRules);

    Groupon findRulesId(Integer id);

    List<GoodsAndGrouponAndGrouponRules> get(GoodsAndGrouponAndGrouponRules demo);

    List<Groupon> getWxGrouponList();

    int[] queryGrouponIds();

    List<Groupon> queryAll();

    int count();

    int countGrouponId();
}*/
