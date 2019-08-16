package com.cskaoyan.springboot.demo.been;

import java.util.List;

public class Data {
    private String avatar;
    private String name;
    private List<String> perms;
    private List<String> roles;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPerms() {
        return perms;
    }

    public void setPerms(List<String> perms) {
        this.perms = perms;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Data{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", perms=" + perms +
                ", roles=" + roles +
                '}';
    }
}
