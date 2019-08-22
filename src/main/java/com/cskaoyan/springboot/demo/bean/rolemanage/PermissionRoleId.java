package com.cskaoyan.springboot.demo.bean.rolemanage;

public class PermissionRoleId {
    int roleId;
    String[] permissions;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
}
