package com.cskaoyan.springboot.demo.controller.group;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.mall.DataWithItemAndTotal;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithList;
import com.cskaoyan.springboot.demo.service.groupService.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("admin")
@RestController
public class GroupRulesController {

    @Autowired
    GroupService groupService;
    /**
     * 分页展示团购规则列表
     * @param page
     * @param limit
     * @param goodsid
     * @return
     */
    @RequestMapping("groupon/list")
    public MessageWithData showGroupRulesListByPage(int page, int limit, Integer goodsid){
        MessageWithData messageWithData = new MessageWithData();
        DataWithItemAndTotal groupRulesData = groupService.findGroupRulesListByPageByCondition(page, limit, goodsid);
        if(groupRulesData != null){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            messageWithData.setData(groupRulesData);
            return messageWithData;
        }
        return null;
    }

    /**
     * 修改团购规则
     * @param grouponRules
     * @return
     */
    @RequestMapping("groupon/update")
    public MessageWithData updateGroupRules(@RequestBody GrouponRules grouponRules){
        MessageWithData messageWithData = new MessageWithData();
        int num = groupService.updateGroupRules(grouponRules);
        if(num > 0){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            return messageWithData;
        }
        return null;
    }

    @RequestMapping("groupon/delete")
    public MessageWithData deleteGroupRules(@RequestBody GrouponRules grouponRules){
        MessageWithData messageWithData = new MessageWithData();
        int num = groupService.deleteGroupRules(grouponRules);
        if(num > 0){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            return messageWithData;
        }
        return null;
    }

}
