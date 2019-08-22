package com.cskaoyan.springboot.demo.bean.systembean;

import java.util.List;

public class Permissions<T> {
    List assignedPermissions;
    T systemPermissions;

    public List getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(List assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public T getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(T systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
