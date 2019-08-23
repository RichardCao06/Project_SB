package com.cskaoyan.springboot.demo.bean;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
public class GoodsInsert {
    List<Attribute> attributes;

    Goods goods;

    List<Product> products;

    List<Specification> specifications;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }
}
