package com.cskaoyan.springboot.demo.bean.systembean;

public class ResponseVo<T> {
    T data;
    String errmsg;
    int errno;

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

    @Override
    public String toString() {
        return "ResponseVo{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }
}
