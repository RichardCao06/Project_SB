package com.cskaoyan.springboot.demo.service.popularize.Impl;

import com.cskaoyan.springboot.demo.bean.Ad;
import com.cskaoyan.springboot.demo.bean.AdExample;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.mapper.AdMapper;
import com.cskaoyan.springboot.demo.service.popularize.AdService;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdServiceImpl  implements AdService {
   @Resource
   AdMapper adMapper;
    @Override
    public ResponVo<Ad> list(String name, String content,Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        AdExample adExample=new AdExample();
        AdExample.Criteria criteria=adExample.createCriteria();
        if(!("".equals(name)||name==null)){
            criteria = criteria.andNameLike("%"+name+"%");
        }
        if (!("".equals(content)||content==null)){
            criteria = criteria.andContentLike("%"+content+"%");
        }

        List<Ad> list=adMapper.selectByExample(adExample);
        long total = adMapper.countByExample(adExample);
        return new ResponVo<Ad>((int)total,list);
    }

    @Override
    public int update(Ad ad) {
       int i=adMapper.updateByPrimaryKey(ad);
       return i;
    }

    @Override
    public void delect(Ad ad) {
       adMapper.deleteByPrimaryKey(ad.getId());
    }

    @Override
    public void create(Ad ad) {

        adMapper.insert(ad);
    }

}
