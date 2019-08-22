package com.cskaoyan.springboot.demo.bean;

public class AdminVo extends Admin {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    @Override
    public String toString() {
        return "AdminVo{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
