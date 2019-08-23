/*package com.cskaoyan.springboot.demo.controller.popularize;

import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.GrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.Errmsg;
import com.cskaoyan.springboot.demo.bean.popularize.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.GoodsMapper;
import com.cskaoyan.springboot.demo.mapper.GrouponMapper;
import com.cskaoyan.springboot.demo.mapper.GrouponRulesMapper;
import com.cskaoyan.springboot.demo.service.popularize.GrouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class GrouponController {
    @Autowired
    GrouponService grouponService;

   @Autowired
   GrouponMapper grouponMapper;
   @Autowired
   GoodsMapper goodsMapper;
   @Autowired
   GrouponRulesMapper grouponRulesMapper;

    @RequestMapping("groupon/listRecord")
    @ResponseBody
    public Map<String,Object> list(int page, int limit, String sort, String order, String goodsId){
        List<GoodsAndGrouponAndGrouponRules> ggrList = new ArrayList<>();
        String[] s = {} ;
        //分次查询
        if (goodsId == null) goodsId = "";
        List<Goods> goodsList = goodsMapper.getListRecord(sort ,order , goodsId);
        System.out.println("goodsList.size() = " + goodsList.size());
        for (Goods goods:goodsList ) {
            int id = goods.getId();
            GrouponRules rules = grouponRulesMapper.findGoodsId(id);
            if(rules != null){
                GrouponRules selectGrouponRules = rules;
                Goods selectGoods = goods;
                Groupon groupon = grouponMapper.findRulesId(selectGrouponRules.getId());
                if(groupon != null){
                    Groupon selectGroupon = groupon;
                    GoodsAndGrouponAndGrouponRules result = new GoodsAndGrouponAndGrouponRules(selectGoods , selectGroupon , selectGrouponRules ,s);
                    ggrList.add(result);
                }
            }
        }
        //分页
        PageHelper.startPage(page, limit);
       *//* PageInfo<GoodsAndGrouponAndGrouponRules> ggrPageInfo = new PageInfo<>(ggrList);
        ResponVo<GoodsAndGrouponAndGrouponRules> ggrPageVO = new ResponVo(ggrPageInfo.getTotal(),ggrPageInfo.getList());
        Errmsg<ResponVo> errmsg = new Errmsg(ggrPageVO ,"成功" , 0);
        return errmsg;*//*
       Map<String,Object> map=new HashMap<>();
       map.put("data",ggrList);
       map.put("errmsg","成功");
       map.put("errno",0);
       return map;
    }

}*/
