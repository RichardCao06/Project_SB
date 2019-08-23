package com.cskaoyan.springboot.demo.Vo;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/18
 */
public class DataResult<T> {
    List<T> items;
    long total;


    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
