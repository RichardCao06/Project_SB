package com.cskaoyan.springboot.demo.bean.rolemanage;

import java.util.List;

public class PerList {

    String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "PerList{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
