package com.cskaoyan.springboot.demo.bean.mall;

import java.util.Date;
import java.util.List;

public class CategoryLevelOne {
    private Integer id;

    private String name;

    private String keywords;

    private String desc;

    private Integer pid;

    private String iconUrl;

    private String picUrl;

    private String level;

    private Boolean deleted;

    private List<CategoryLevelTwo> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<CategoryLevelTwo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryLevelTwo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryLevelOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", desc='" + desc + '\'' +
                ", pid=" + pid +
                ", iconUrl='" + iconUrl + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", level='" + level + '\'' +
                ", deleted=" + deleted +
                ", children=" + children +
                '}';
    }
}
