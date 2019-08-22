package com.cskaoyan.springboot.demo.bean;

import java.util.Arrays;

public class UserLoginBean {
    private String username;
    private String avatar;
    private int[] roleIds;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "UserLoginBean{" +
                "username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleIds=" + Arrays.toString(roleIds) +
                '}';
    }
}
