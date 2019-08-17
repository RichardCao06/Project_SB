package com.cskaoyan.springboot.demo.bean;

public class Message {
    private int errno;
    private String data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "message{" +
                "errno='" + errno + '\'' +
                ", data='" + data + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
