package com.cskaoyan.springboot.demo.service.user;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.PageBean;

public interface AddressService {
    PageBean<Address> findByCondition(int page, int limit, String name, Integer userId,
                                      String sort, String order);
}
