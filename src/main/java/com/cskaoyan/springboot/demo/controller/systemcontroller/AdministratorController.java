package com.cskaoyan.springboot.demo.controller.systemcontroller;

import com.cskaoyan.springboot.demo.bean.systembean.Admin2;
import com.cskaoyan.springboot.demo.bean.systembean.AdminCustom;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.bean.systembean.SystemRole;
import com.cskaoyan.springboot.demo.service.systemservice.AdministratorService;
import com.cskaoyan.springboot.demo.util.ControllerLog;
import com.cskaoyan.springboot.demo.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public ResponseVo<Page> queryList(int page,int limit,String sort,String order,String username) {
        if (username != null) {
            return administratorService.searchByName(username);
        } else {
            Page<AdminCustom> page1 = new Page<>();
            List<AdminCustom> adminCustoms = administratorService.queryRoleList(sort, order);
            page1.setItems(adminCustoms);
            page1.setTotal(adminCustoms.size());
            ResponseVo<Page> responseVo = new ResponseVo<>();
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(page1);
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
