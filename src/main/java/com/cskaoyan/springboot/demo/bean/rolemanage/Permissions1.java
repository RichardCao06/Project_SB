package com.cskaoyan.springboot.demo.bean.rolemanage;

import java.util.List;

public class Permissions1<T> {
    List assignedPermissions;
    List<T> systemPermissions;

    public List getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(List assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List<T> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<T> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
