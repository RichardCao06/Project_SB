package com.cskaoyan.springboot.demo.bean.user;

public class Errno2 {
    private String errmsg;
    private int errno;

    public Errno2() {
    }

    public Errno2(String errmsg, int errno) {
        this.errmsg = errmsg;
        this.errno = errno;
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
        return "Errno2{" +
                "errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }
}
