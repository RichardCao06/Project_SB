package com.cskaoyan.springboot.demo.service.wx.user.impl;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.AddressExample;
import com.cskaoyan.springboot.demo.bean.user.WxAddress;
import com.cskaoyan.springboot.demo.bean.user.WxAddressDetail;
import com.cskaoyan.springboot.demo.mapper.AddressMapper;
import com.cskaoyan.springboot.demo.service.wx.user.WxAddressService;
import com.cskaoyan.springboot.demo.service.wx.user.WxRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WxAddressServiceImpl implements WxAddressService {
    @Resource
    AddressMapper addressMapper;
    @Autowired
    WxRegionService regionService;

    @Override
    public List<WxAddress> findByUserId(Integer userId) {
        List<WxAddress> list = new ArrayList<>();
        //根据userId获取List<Address>
        AddressExample addressExample = new AddressExample();
        if(!("".equals(userId)||userId==null)){
            addressExample.createCriteria().andUserIdEqualTo(userId);
        }
        List<Address> addresses = addressMapper.selectByExample(addressExample);

        //转化为List<WxAddress>
        for (Address address : addresses) {
            WxAddress wxAddress = new WxAddress();
            wxAddress.setId(address.getId());
            wxAddress.setIsDefault(address.getIsDefault());
            wxAddress.setMobile(address.getMobile());
            wxAddress.setName(address.getName());
            String province = regionService.getName(address.getProvinceId());
            String city = regionService.getName(address.getCityId());
            String area = regionService.getName(address.getAreaId());
            wxAddress.setDetailedAddress(province + city + area + " " + address.getAddress());
            list.add(wxAddress);
        }

        return list;
    }

    @Override
    public WxAddressDetail findByAddressId(Integer addressId) {
        Address a = getById(addressId);
        //转化为wxAddresssDetail
        return new WxAddressDetail(a.getAddress(),a.getAreaId(),regionService.getName(a.getAreaId()),
                a.getCityId(),regionService.getName(a.getCityId()),addressId,a.getIsDefault(),
                a.getMobile(),a.getName(),a.getProvinceId(),regionService.getName(a.getProvinceId()));
    }

    @Override
    public boolean update(Address address) {
        //完善address
        Address pre = getById(address.getId());
        address.setUserId(pre.getUserId());
        address.setAddTime(pre.getAddTime());
        address.setUpdateTime(new Date());
        address.setDeleted(pre.getDeleted());
        //update
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andIdEqualTo(address.getId());
        int result = addressMapper.updateByExample(address, addressExample);
        return result>0;
    }

    @Override
    public boolean insert(Address address,Integer userId) {
        Date date = new Date();
        address.setUserId(userId);
        address.setAddTime(date);
        address.setUpdateTime(date);
        address.setDeleted(false);
        int result = addressMapper.insert(address);
        return result>0;
    }

    @Override
    public boolean delete(Integer addressId) {
        int result = addressMapper.deleteByPrimaryKey(addressId);
        return result>0;
    }

    //根据addressId获取address
    private Address getById(Integer addressId){
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
