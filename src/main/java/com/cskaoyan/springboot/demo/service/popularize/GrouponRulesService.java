package com.cskaoyan.springboot.demo.service.popularize;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;

import java.util.List;

public interface GrouponRulesService {
    ResponVo<GrouponRules> getList(int page, int limit, String sort, String order, String goodsId);
    int create(GrouponRules grouponRules);

    GrouponRules findGoodsId(Integer goodsId);

    int delete(GrouponRules grouponRules);

    int update(GrouponRules grouponRules);

    List<GrouponRules> wxGetList(int page, int size);

    int count();

    GrouponRules getRulesId(Integer rulesId);
}
