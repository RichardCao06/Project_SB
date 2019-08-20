package com.cskaoyan.springboot.demo.service.groupService;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.mall.DataWithItemAndTotal;

import java.util.List;

public interface GroupService {
    /**
     * 按条件分页查询groupRules数据
     * @param page
     * @param limit
     * @param goodsid
     * @return
     */
    DataWithItemAndTotal findGroupRulesListByPageByCondition(int page, int limit, Integer goodsid);

    /**
     * 修改groupRules
     * @param grouponRules
     * @return
     */
    int updateGroupRules(GrouponRules grouponRules);

    /**
     * 删除groupRules
     * @param grouponRules
     * @return
     */
    int deleteGroupRules(GrouponRules grouponRules);
}
