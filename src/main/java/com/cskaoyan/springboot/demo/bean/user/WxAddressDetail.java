package com.cskaoyan.springboot.demo.bean.user;

public class WxAddressDetail {
    private String address;
    private Integer areaId;
    private String areaName;
    private Integer cityId;
    private String cityName;
    private Integer id;
    private boolean isDefault;
    private String mobile;
    private String name;
    private Integer provinceId;
    private String provinceName;

    public WxAddressDetail() {
    }

    public WxAddressDetail(String address, Integer areaId, String areaName, Integer cityId,
                           String cityName, Integer id, boolean isDefault, String mobile, String name,
                           Integer provinceId, String provinceName) {
        this.address = address;
        this.areaId = areaId;
        this.areaName = areaName;
        this.cityId = cityId;
        this.cityName = cityName;
        this.id = id;
        this.isDefault = isDefault;
        this.mobile = mobile;
        this.name = name;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "WxAddressDetail{" +
                "address='" + address + '\'' +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", id=" + id +
                ", isDefault=" + isDefault +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
