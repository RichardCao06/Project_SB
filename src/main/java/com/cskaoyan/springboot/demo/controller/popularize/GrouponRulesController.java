package com.cskaoyan.springboot.demo.controller.popularize;

import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.GrouponRulesMapper;
import com.cskaoyan.springboot.demo.service.popularize.GrouponRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GrouponRulesController {
    @Autowired
    GrouponRulesService grouponRulesService;
    @RequestMapping("groupon/list")
    @ResponseBody
    public Map<String,Object> getList(int page, int limit, String sort, String order, String goodsId) {
        if (goodsId == null) goodsId = "";
        ResponVo<GrouponRules> grouponRulesPageVO = grouponRulesService.getList(page, limit, sort, order, goodsId);
        Map<String, Object> map = new HashMap<>();
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", grouponRulesPageVO);
        return map;
    }
    @RequestMapping("groupon/delete")
    @ResponseBody
    public  Map<String,Object> delete(@RequestBody GrouponRules grouponRules){
        int delete = grouponRulesService.delete(grouponRules);
        Map<String, Object> map = new HashMap<>();
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", delete);
        return map;

    }

    @RequestMapping("groupon/update")
    @ResponseBody
    public Map<String,Object> update(@RequestBody GrouponRules grouponRules) {
        int update = grouponRulesService.update(grouponRules);
        Map<String, Object> map = new HashMap<>();
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", grouponRules);
        return map;

    }




    /*    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseVO<GrouponRules> create(@RequestBody GrouponRules grouponRules) {
        ResponseVO<GrouponRules> responseVO = new ResponseVO<>();
        Goods goods = goodsService.queryOneById(grouponRules.getGoodsId());
        //GrouponRules old = grouponRulesService.findGoodsId(grouponRules.getGoodsId());
        if (goods != null && grouponRules.getDiscount() != 0 && grouponRules.getDiscountMember() != null && grouponRules.getExpireTime() != null){
            GrouponRules rules = new GrouponRules();
            rules.setGoodsId(goods.getId());
            rules.setGoodsName(goods.getName());
            rules.setPicUrl(goods.getPicUrl());
            rules.setAddTime(goods.getAddTime());
            rules.setUpdateTime(goods.getUpdateTime());
            rules.setDeleted(goods.isDeleted());
            rules.setDiscount(grouponRules.getDiscount());
            rules.setDiscountMember(grouponRules.getDiscountMember());
            rules.setExpireTime(grouponRules.getExpireTime());
            int insert = grouponRulesService.create(rules);
            if (insert == 1) {
                responseVO.setData(rules);
                responseVO.setErrmsg("成功");
                responseVO.setErrno(0);
            }else {
                responseVO.setErrmsg("错误");
                responseVO.setErrno(-1);
            }
        }else {
            responseVO.setErrmsg("参数值不对");
            responseVO.setErrno(402);
        }
        return  responseVO ;
    }*/
}
