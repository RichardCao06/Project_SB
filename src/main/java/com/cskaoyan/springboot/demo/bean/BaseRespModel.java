package com.cskaoyan.springboot.demo.bean;

public class BaseRespModel<T> {

    T data;
    String errmsg;
    int errno;

    public BaseRespModel() {
    }

    public BaseRespModel(T data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
