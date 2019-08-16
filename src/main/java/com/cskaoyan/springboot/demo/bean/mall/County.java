package com.cskaoyan.springboot.demo.bean.mall;

public class County {
    private int id;
    private int pid;
    private String name;
    private int type;
    private int code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "County{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code=" + code +
                '}';
    }
}
