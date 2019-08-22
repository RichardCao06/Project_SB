package com.cskaoyan.springboot.demo.bean.popularize;

import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.bean.Groupon;
import com.cskaoyan.springboot.demo.bean.GrouponRules;

public class GoodsAndGrouponAndGrouponRules {
    Goods goods;
    Groupon groupon;
    GrouponRules rules;
    String[] subGroupons;

    public GoodsAndGrouponAndGrouponRules(Goods goods, Groupon groupon, GrouponRules rules, String[] subGroupons) {
        this.goods = goods;
        this.groupon = groupon;
        this.rules = rules;
        this.subGroupons = subGroupons;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public String[] getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(String[] subGroupons) {
        this.subGroupons = subGroupons;
    }
}
