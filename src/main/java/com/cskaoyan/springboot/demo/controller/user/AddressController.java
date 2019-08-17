package com.cskaoyan.springboot.demo.controller.user;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.Errno;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("list")
    public Object list(int page,int limit,String name,Integer userId,String sort,String order){
        PageBean<Address> addresses = addressService.findByCondition(page, limit, name, userId, sort, order);
        return new Errno<Address>(addresses,"成功",0);
    }
}
