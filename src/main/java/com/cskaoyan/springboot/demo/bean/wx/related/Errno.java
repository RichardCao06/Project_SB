package com.cskaoyan.springboot.demo.bean.wx.related;

import com.cskaoyan.springboot.demo.bean.Goods;

import java.util.List;

public class Errno {
    List<Goods> goodsList;
    String errmsg;
    int errno;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    @Override
    public String toString() {
        return "Errno{" +
                "goodsList=" + goodsList +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }
}
