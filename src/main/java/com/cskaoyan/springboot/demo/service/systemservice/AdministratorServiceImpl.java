package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.RoleExample;
import com.cskaoyan.springboot.demo.bean.systembean.*;
import com.cskaoyan.springboot.demo.mapper.AdminMapper;
import com.cskaoyan.springboot.demo.mapper.RoleMapper;
import com.cskaoyan.springboot.demo.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<SystemRole> querySysRole() {

        return roleMapper.queryRoleIdAndName();
    }

    @Override
    public List<AdminCustom> queryRoleList(String sort, String order) {

        return adminMapper.queryRoleList();
    }

    @Override
    public List<Role> queryAllRoleMsg() {
        RoleExample example = new RoleExample();
        example.createCriteria().andAddTimeIsNotNull();
        List<Role> roles = roleMapper.selectByExample(example);
        return roles;
    }

    @Override
    public ResponseVo insertAdmin(Admin2 admin) {
        String s = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(s);
        Date parse = new Date();
        dateFormat.format(parse);
        System.out.println(parse);
        admin.setAddTime(parse);
        admin.setUpdateTime(parse);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setErrno(0);
        Md5Util.getMD5(admin.getPassword());
        System.out.println(admin.getPassword());
        int status = adminMapper.creatAdmin(admin);
        if(status == 1){
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
        }
        Admin2 admin2 = adminMapper.returnByName(admin.getUsername());

        responseVo.setData(admin2);

        //setlog(admin,"新增管理员" );
        return responseVo;
    }

    @Override
    public ResponseVo deleteAdmin(int id) {
        int i = adminMapper.deleteByPrimaryKey(id);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(i == 1){
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("联系管理员");
        }
        responseVo.setErrno(0);
        return responseVo;

    }

    @Override
    public ResponseVo updateAdmin(Admin2 admin) {
        int i = adminMapper.updateByPrimaryKey(admin);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(i == 1){
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
        }

        String s = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(s);
        Date parse = new Date();
        try {
            parse = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        admin.setUpdateTime(parse);
        responseVo.setErrno(0);
        responseVo.setData(admin);
        return responseVo;
    }

    @Override
    public ResponseVo searchByName(String username) {
        username = "%" + username + "%";
        List<AdminCustom> adminCustoms = adminMapper.searchByName(username);
        SystemRole2 role2 = new SystemRole2();
        role2.setItems(adminCustoms);
        role2.setTotal(adminCustoms.size());
        ResponseVo<Object> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public Admin2 returnByName(String username) {

        return null;
    }
}
