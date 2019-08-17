package com.cskaoyan.springboot.demo.bean;

import java.util.List;

public class Errno<T>{
    private PageBean<T> data;
    private String errmsg;
    private int errno;

    public Errno() {
    }

    public Errno(PageBean<T> data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public PageBean<T> getData() {
        return data;
    }

    public void setData(PageBean<T> data) {
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

    @Override
    public String toString() {
        return "Errno{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }
}
