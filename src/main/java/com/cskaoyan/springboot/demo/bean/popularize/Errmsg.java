package com.cskaoyan.springboot.demo.bean.popularize;

import com.cskaoyan.springboot.demo.bean.Coupon;

public class Errmsg<T> {
    private ResponVo<T> data;
    private String errmsg;
    private int errno;

    public Errmsg(){}

    public Errmsg(ResponVo<T> data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public ResponVo<T> getData() {
        return data;
    }

    public void setData(ResponVo<T> data) {
        this.data = data;
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
}
