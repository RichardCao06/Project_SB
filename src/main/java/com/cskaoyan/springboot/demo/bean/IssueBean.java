package com.cskaoyan.springboot.demo.bean;

public class IssueBean {

    private Issue data;
    private int errno;
    private String errmsg;

    public Issue getData() {
        return data;
    }

    public void setData(Issue data) {
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
