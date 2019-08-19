package com.cskaoyan.springboot.demo.bean.mall;

public class CategoryData {
    private String label;
    private int value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
