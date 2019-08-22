package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Admin;
import com.cskaoyan.springboot.demo.bean.AdminExample;
import com.cskaoyan.springboot.demo.bean.Role;
import com.cskaoyan.springboot.demo.bean.RoleExample;
import com.cskaoyan.springboot.demo.bean.systembean.*;
import com.cskaoyan.springboot.demo.mapper.AdminMapper;
import com.cskaoyan.springboot.demo.mapper.RoleMapper;
import com.cskaoyan.springboot.demo.util.Md5Util;
import com.cskaoyan.springboot.demo.util.MyException;
import com.cskaoyan.springboot.demo.util.ServiceLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @ServiceLog
    public ResponseVo insertAdmin(Admin2 admin){
        /*用户名查重判断*/
        ResponseVo<Object> responseVo = new ResponseVo<>();
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size() != 0){
            responseVo.setErrmsg("用户名已经存在");
            responseVo.setErrno(1);
            responseVo.setData(null);
            //return responseVo;
            throw new MyException();//抛出自定义异常，转入日志处理异常信息
            //return responseVo;
        }
        else {
            String s = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat dateFormat = new SimpleDateFormat(s);
            Date parse = new Date();
            String format = dateFormat.format(parse);
            System.out.println(format);

            admin.setAddTime(parse);
            admin.setUpdateTime(parse);

            responseVo.setErrno(0);
            String password = Md5Util.getMD5(admin.getPassword());
            admin.setPassword(password);
            int status = adminMapper.creatAdmin(admin);
            if (status == 1) {
                responseVo.setErrmsg("成功");
            } else {
                responseVo.setErrmsg("失败");
            }
            Admin2 admin2 = adminMapper.returnByName(admin.getUsername());

            responseVo.setData(admin2);

            //setlog(admin,"新增管理员" );
            return responseVo;
        }
    }

    @Override
    @ServiceLog
    public ResponseVo deleteAdmin(int id) {
        int i = adminMapper.deleteByPrimaryKey(id);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        //int j = 1/0;
        if(i == 1){
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("联系管理员");
        }
        responseVo.setErrno(0);
        return responseVo;

    }

    @Override
    @ServiceLog
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
    public ResponseVo searchByName(int page,int limit,String username) {
        PageHelper.startPage(page,limit);

        username = "%" + username + "%";
        List<AdminCustom> adminCustoms = adminMapper.searchByName(username);

        PageInfo<AdminCustom> pageInfo = new PageInfo<>(adminCustoms);
        SystemRole2 role2 = new SystemRole2();
        role2.setItems(adminCustoms);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

}
