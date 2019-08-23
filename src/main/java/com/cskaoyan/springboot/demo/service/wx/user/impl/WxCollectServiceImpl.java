package com.cskaoyan.springboot.demo.service.wx.user.impl;


import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.Collect;
import com.cskaoyan.springboot.demo.bean.user.CollectExample;
import com.cskaoyan.springboot.demo.bean.user.WxCollect;
import com.cskaoyan.springboot.demo.mapper.GoodsMapper;
import com.cskaoyan.springboot.demo.mapper.user.CollectMapper;
import com.cskaoyan.springboot.demo.service.wx.user.WxCollectService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WxCollectServiceImpl implements WxCollectService {
    @Resource
    CollectMapper collectMapper;
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public PageBean<WxCollect> findByUserId(int page, int limit, Integer userId, Byte type) {
        PageHelper.startPage(page,limit);
        //查询List<Collect>
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andUserIdEqualTo(userId).andTypeEqualTo(type);
        List<Collect> collects = collectMapper.selectByExample(collectExample);
        //转为List<WxCollect>
        ArrayList<WxCollect> list = new ArrayList<>();
        for (Collect c : collects) {
            Goods g = goodsMapper.selectByPrimaryKey(c.getValueId());
            WxCollect wxCollect = new WxCollect(g.getBrief(),c.getId(),g.getName(),g.getPicUrl(),
                    g.getRetailPrice(),c.getType(),c.getValueId());
            list.add(wxCollect);
        }
        long total = collectMapper.countByExample(collectExample);
        return new PageBean<>(list,(int)total);
    }

    @Override
    public String update(Integer userId, Byte type, Integer valueId) {
        Integer collectId = isCollectProduct(userId,type,valueId);
        String op;
        if(collectId != null) {
            collectMapper.deleteByPrimaryKey(collectId);
            op = "delete";
        }else {
            Date date = new Date();
            collectMapper.insert(new Collect(null,userId,valueId,type,date,date,false));
            op = "add";
        }
        return op;
    }

    //查询有没有收藏该商品
    private Integer isCollectProduct(Integer userId, Byte type, Integer valueId){
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andUserIdEqualTo(userId).andTypeEqualTo(type).
                andValueIdEqualTo(valueId);
        List<Collect> collects = collectMapper.selectByExample(collectExample);
        if(collects.size()==0)return null;
        else return collects.get(0).getId();
    }
}
