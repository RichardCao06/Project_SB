package com.cskaoyan.springboot.demo.systembean;

public class SystemRole2<T> {
    T items;
    int total;

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
