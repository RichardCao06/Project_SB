package com.cskaoyan.springboot.demo.bean.wx.order;

import java.util.List;

public class WxResponseData<T> {
    private int count;
    private int totalPages;
    private List<T> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxResponseData{" +
                "count=" + count +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}
