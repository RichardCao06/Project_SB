package com.cskaoyan.springboot.demo.been;

import java.util.List;

public class PageBean <T>{
    private List<T> items;
    private long total;

    public PageBean() {
    }

    public PageBean(List<T> items, long total) {
        this.items = items;
        this.total = total;
    }

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
        return "PageBean{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
