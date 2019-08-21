package com.cskaoyan.springboot.demo.bean.wx.category;

import com.cskaoyan.springboot.demo.bean.Goods;

import java.util.List;

public class FloorGoodsData {
    private int id;
    private String name;
    List<Goods> goodsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "FloorGoodsData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
