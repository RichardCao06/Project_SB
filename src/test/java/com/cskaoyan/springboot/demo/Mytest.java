package com.cskaoyan.springboot.demo;

import com.cskaoyan.springboot.demo.been.Ad;
import com.cskaoyan.springboot.demo.been.AdExample;
import com.cskaoyan.springboot.demo.mapper.AdMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class Mytest {
    /*@Autowired
    AdMapper adMapper;

    @Test
    public void contextLoads() {
        AdExample adExample = new AdExample();
        adExample.createCriteria();
        List<Ad> ads = adMapper.selectByExample(adExample);
        System.out.println(ads);
    }*/
}
