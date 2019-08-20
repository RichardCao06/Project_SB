package com.cskaoyan.springboot.demo.bean;

import java.util.List;

public class KeywordData<T>  {

    List<T> items;
    private long total;

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

    public KeywordData(List<T> items, long total) {
        this.items = items;
        this.total = total;
    }

    public KeywordData() {
    }
}
