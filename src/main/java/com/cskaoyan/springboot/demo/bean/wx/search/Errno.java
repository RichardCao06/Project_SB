package com.cskaoyan.springboot.demo.bean.wx.search;
public class Errno {
    String errmsg;
    int errno;
    Dataz data;

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

    public Dataz getData() {
        return data;
    }

    public void setData(Dataz data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Errno{" +
                "errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                ", data=" + data +
                '}';
    }
}
