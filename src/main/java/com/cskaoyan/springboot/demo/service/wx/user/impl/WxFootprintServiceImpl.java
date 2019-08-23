package com.cskaoyan.springboot.demo.service.wx.user.impl;



import com.cskaoyan.springboot.demo.bean.Footprint;
import com.cskaoyan.springboot.demo.bean.FootprintExample;
import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.WxFootPrint;
import com.cskaoyan.springboot.demo.mapper.FootprintMapper;
import com.cskaoyan.springboot.demo.mapper.GoodsMapper;
import com.cskaoyan.springboot.demo.service.wx.user.WxFootprintService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WxFootprintServiceImpl implements WxFootprintService {
    @Resource
    FootprintMapper footprintMapper;
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public PageBean<WxFootPrint> findByUserId(int page, int size, Integer userId) {
        PageHelper.startPage(page,size);
        FootprintExample footprintExample = new FootprintExample();
        footprintExample.createCriteria().andUserIdEqualTo(userId);
        List<Footprint> footprints = footprintMapper.selectByExample(footprintExample);
        //转为List<WxFootPrint>
        List<WxFootPrint> list = new ArrayList<>();
        for (Footprint f : footprints) {
            Goods g = goodsMapper.selectByPrimaryKey(f.getGoodsId());
            WxFootPrint wxFootPrint = new WxFootPrint(f.getAddTime(),g.getBrief(),f.getGoodsId(),
                    f.getId(),g.getName(),g.getPicUrl(),g.getRetailPrice());
            list.add(wxFootPrint);
        }
        long total = footprintMapper.countByExample(footprintExample);
        return new PageBean<>(list,total);
    }
}
