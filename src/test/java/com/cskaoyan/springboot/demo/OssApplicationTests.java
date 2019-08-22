package com.cskaoyan.springboot.demo;

import com.cskaoyan.springboot.demo.bean.AdminVo;
import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.UserLoginBean;
import com.cskaoyan.springboot.demo.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OssApplicationTests {
    @Resource
    AdminMapper adminMapper;

    @Test
    public void contextLoads() {
    }
    @Test
    public void mytest(){

        UserLoginBean bean = adminMapper.queryAdminByUsername("admin123");
        System.out.println(bean);
    }
    @Test
    public  void mytest1(){
        int[] a = {1};
        Role role = adminMapper.queryRoleByIds(a);
        System.out.println(role);
    }

}
