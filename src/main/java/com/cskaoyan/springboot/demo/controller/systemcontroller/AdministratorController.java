package com.cskaoyan.springboot.demo.controller.systemcontroller;

import com.cskaoyan.springboot.demo.bean.systembean.*;
import com.cskaoyan.springboot.demo.service.systemservice.AdministratorService;
import com.cskaoyan.springboot.demo.util.ControllerLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;


    @RequestMapping("role/options")
    public ResponseVo<List<SystemRole>> queryRole(){
        List<SystemRole> systemRoles = administratorService.querySysRole();
        ResponseVo<List<SystemRole>> responseVo = new ResponseVo<>();
        responseVo.setData(systemRoles);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    @RequestMapping("admin/list")
    public ResponseVo queryList(int page,int limit,String sort,String order,String username) {
        if (username != null) {
            return administratorService.searchByName(page,limit,username);
        } else {
            PageHelper.startPage(page,limit);
            //Page<AdminCustom> page1 = new Page<>();
            List<AdminCustom> adminCustoms = administratorService.queryRoleList(sort, order);
            PageInfo<AdminCustom> pageInfo = new PageInfo<>(adminCustoms);
            SystemRole2<List<AdminCustom>> role2 = new SystemRole2<>();
            role2.setItems(adminCustoms);
            role2.setTotal((int) pageInfo.getTotal());
            ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(role2);
            return responseVo;
        }
    }

   /* @RequestMapping("role/list")
    public ResponseVo<SystemRole2> queryAllRole(){
        List<Role> roles = roleService.queryAllRoleMsg();
        SystemRole2<List<Role>> role2 = new SystemRole2<>();
        role2.setItems(roles);
        role2.setTotal(roles.size());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(role2);
        return responseVo;
    }*/

    @RequestMapping("admin/create")
    @ControllerLog
    public ResponseVo admincreate(@RequestBody Admin2 admin){
        return administratorService.insertAdmin(admin);
    }

    @RequestMapping("admin/delete")
    @ControllerLog
    public ResponseVo deleteadmin(@RequestBody Admin2 admin){
        return administratorService.deleteAdmin(admin.getId());
    }

    @RequestMapping("admin/update")
    @ControllerLog
    public ResponseVo updateadmin(@RequestBody Admin2 admin){
        return administratorService.updateAdmin(admin);
    }


}
