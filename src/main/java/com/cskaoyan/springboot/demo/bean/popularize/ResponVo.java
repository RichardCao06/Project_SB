package com.cskaoyan.springboot.demo.bean.popularize;

import java.util.List;

public class ResponVo<T> {
    private Integer total;
    private  List<T>  items;
    public  ResponVo(List<T> items){}
    public ResponVo(Integer total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
