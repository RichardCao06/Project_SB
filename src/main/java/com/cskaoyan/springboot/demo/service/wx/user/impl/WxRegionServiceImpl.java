package com.cskaoyan.springboot.demo.service.wx.user.impl;


import com.cskaoyan.springboot.demo.bean.Region;
import com.cskaoyan.springboot.demo.bean.RegionExample;
import com.cskaoyan.springboot.demo.mapper.RegionMapper;
import com.cskaoyan.springboot.demo.service.wx.user.WxRegionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class WxRegionServiceImpl implements WxRegionService {
    @Resource
    RegionMapper regionMapper;

    @Override
    public String getName(Integer id) {
        Region region = regionMapper.selectByPrimaryKey(id);
        return region.getName();
    }
}
