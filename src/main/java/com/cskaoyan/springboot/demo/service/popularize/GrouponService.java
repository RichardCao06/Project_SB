package com.cskaoyan.springboot.demo.service.popularize;

import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;

import java.util.List;

public interface GrouponService {

     ResponVo<Groupon> list(int page, int limit, String sort, String order, String goodsId);

    int create(GrouponRules grouponRules);

    Groupon findRulesId(Integer id);

    List<Groupon> getWxGrouponList();

    List<Groupon> getGrouponRulesByGoodsId(int goodsId);

    List<Groupon> queryAll();

    int count();

    int countGrouponId();

    Groupon getGrouponId(int grouponId);
}