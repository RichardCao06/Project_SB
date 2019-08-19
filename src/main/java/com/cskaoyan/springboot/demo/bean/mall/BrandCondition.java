package com.cskaoyan.springboot.demo.bean.mall;

public class BrandCondition {

    private int page;
    private int limit;
    private Integer id;
    private String name;
    private String sort;
    private String order;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BrandCondition{" +
                "page=" + page +
                ", limit=" + limit +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
