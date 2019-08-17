package com.cskaoyan.springboot.demo.service.user.impl;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.AddressExample;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.mapper.AddressMapper;
import com.cskaoyan.springboot.demo.service.user.AddressService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;

    @Override
    public PageBean<Address> findByCondition(int page, int limit, String name, Integer userId, String sort, String order) {
        PageHelper.startPage(page,limit);
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        if(!("".equals(name)||name==null)){
            criteria = criteria.andNameLike("%" + name + "%");
        }
        if(!("".equals(userId)||userId==null)){
            criteria = criteria.andUserIdEqualTo(userId);
        }
        if(!("".equals(sort)||sort==null)){
            addressExample.setOrderByClause(sort + " " + order);
        }
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        long total = addressMapper.countByExample(addressExample);
        return new PageBean<Address>(addresses,total);
    }
}
