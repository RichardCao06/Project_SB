package com.cskaoyan.springboot.demo.wx.vo;

/**
 * Created by MatthewLi on 2019/8/22
 */
public class BaseRespVO {
    Object data;
    String errmsg;
    Integer errno;



    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public static BaseRespVO ok(Object data){
        BaseRespVO baseRespVo = new BaseRespVO();
        baseRespVo.setData(data);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

}
