package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.bean.Attribute;
import com.cskaoyan.springboot.demo.mapper.AttributeMapper;
import com.cskaoyan.springboot.demo.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/21
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public int insertSelective(Attribute record) {
        return attributeMapper.insertSelective(record);
    }

    @Override
    public List<Attribute> queryByGoodsId(int goodsId) {
        return attributeMapper.queryByGoodsId(goodsId);
    }

    @Override
    public int updateByPrimaryKey(Attribute record) {
        return attributeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Attribute> getAttributeByGoodsId(int goodsId) {
        return attributeMapper.getAttributeByGoodsId(goodsId);
    }

}
