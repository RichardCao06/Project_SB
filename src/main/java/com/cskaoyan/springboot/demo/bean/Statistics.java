package com.cskaoyan.springboot.demo.bean;

public class Statistics {

    private StatData data;
    private int errno;
    private String errmsg;


    public StatData getData() {
        return data;
    }

    public void setData(StatData data) {
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }



    @Override
    public String toString() {
        return "Statistics{" +
                "data=" + data +
                ", errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
