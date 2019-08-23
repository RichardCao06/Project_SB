package com.cskaoyan.springboot.demo.bean.popularize;

import java.util.List;

public class DataVo<T> {
    private Integer count;
    private List<T> data;

    public  DataVo(List<T> items){}

    public Integer getCount() {
        return count;
    }

    public DataVo(Integer count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
