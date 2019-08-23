package com.cskaoyan.springboot.demo.wx.bean;

import com.cskaoyan.springboot.demo.bean.Specification;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/22
 */
public class SpecificationWx {
    private String name;
    private List<Specification> valueList;

    public SpecificationWx() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Specification> getValueList() {
        return valueList;
    }

    public void setValueList(List<Specification> valueList) {
        this.valueList = valueList;
    }
}
