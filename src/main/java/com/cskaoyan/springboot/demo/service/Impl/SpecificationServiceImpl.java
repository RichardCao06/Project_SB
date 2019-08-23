package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.bean.Specification;
import com.cskaoyan.springboot.demo.mapper.SpecificationMapper;
import com.cskaoyan.springboot.demo.service.SpecificationService;
import com.cskaoyan.springboot.demo.wx.bean.SpecificationWx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    SpecificationMapper specificationMapper;

    @Override
    public int insertSelective(Specification record) {
        return specificationMapper.insertSelective(record);
    }

    @Override
    public List<Specification> queryByGoodsId(int id) {
        return specificationMapper.queryByGoodsId(id);
    }

    @Override
    public int updateByPrimaryKey(Specification record) {
        return specificationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return specificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SpecificationWx> querySpecificationWxByGoodsId(int goodsId) {
        return specificationMapper.querySpecificationWxByGoodsId(goodsId);
    }
}
