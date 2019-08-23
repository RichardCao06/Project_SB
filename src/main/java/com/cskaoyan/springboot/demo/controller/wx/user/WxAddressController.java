package com.cskaoyan.springboot.demo.controller.wx.user;


import com.cskaoyan.springboot.demo.bean.Address;
import com.cskaoyan.springboot.demo.bean.user.*;
import com.cskaoyan.springboot.demo.realm.UserTokenManager;
import com.cskaoyan.springboot.demo.service.wx.user.WxAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("wx/address")
public class WxAddressController {
    @Autowired
    WxAddressService wxAddressService;

    @RequestMapping("list")
    public Object list(HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        List<WxAddress> data = wxAddressService.findByUserId(userId);
        return new Errno(data,"成功",0);
    }

    @RequestMapping("detail")
    public Object detail(Integer id){
        WxAddressDetail data = wxAddressService.findByAddressId(id);
        return new Errno(data,"成功",0);
    }

    @RequestMapping("save")
    public Object save(@RequestBody Address address,HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        if(address.getId()==0||address.getId()==null)
            wxAddressService.insert(address,userId);
        else
            wxAddressService.update(address);
        return new Errno(address.getId(),"成功",0);
    }

    @RequestMapping("delete")
    public Object delete(@RequestBody WxBean1 bean){
        wxAddressService.delete(bean.getId());
        return new Errno2("成功",0);
    }
}
