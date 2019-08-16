package com.cskaoyan.springboot.demo.bean.mall;

import java.util.List;

public class BrandData<T> {
    private List<T> items;
    private int total;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BrandData{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
