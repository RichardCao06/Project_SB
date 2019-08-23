package com.cskaoyan.springboot.demo.service.wx.user;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.user.WxAddress;
import com.cskaoyan.springboot.demo.bean.user.WxAddressDetail;

import java.util.List;

public interface WxAddressService {
    List<WxAddress> findByUserId(Integer userId);

    WxAddressDetail findByAddressId(Integer addressId);

    boolean update(Address address);

    boolean insert(Address address, Integer userId);

    boolean delete(Integer id);

}
