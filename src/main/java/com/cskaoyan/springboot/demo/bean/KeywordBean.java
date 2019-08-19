package com.cskaoyan.springboot.demo.bean;

public class KeywordBean {

    private Keyword data;
    private int errno;
    private String errmsg;

    public Keyword getData() {
        return data;
    }

    public void setData(Keyword data) {
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
}
