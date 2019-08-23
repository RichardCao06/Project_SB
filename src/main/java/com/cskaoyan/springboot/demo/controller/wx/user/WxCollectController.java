package com.cskaoyan.springboot.demo.controller.wx.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.Errno;
import com.cskaoyan.springboot.demo.bean.user.WxBean2;
import com.cskaoyan.springboot.demo.bean.user.WxCollect;
import com.cskaoyan.springboot.demo.realm.UserTokenManager;
import com.cskaoyan.springboot.demo.service.wx.user.WxCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("wx/collect")
public class WxCollectController {
    @Autowired
    WxCollectService wxCollectService;

    @RequestMapping("list")
    public Object list(int page, int size, byte type, HttpServletRequest request){
        //userId
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //查询
        HashMap<String, Object> data = new HashMap<>();
        PageBean<WxCollect> pageBean = wxCollectService.findByUserId(page, size, userId, type);
        //组装
        data.put("collectList",pageBean.getItems());
        data.put("totalPages",pageBean.getTotal());
        return new Errno(data,"成功",0);
    }

    @RequestMapping("addordelete")
    public Object addordelete(@RequestBody WxBean2 bean,HttpServletRequest request){
        Byte type = bean.getType();
        Integer valueId = bean.getValueId();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        HashMap<String, String> data = new HashMap<>();
        data.put("type",wxCollectService.update(userId,type,valueId));
        return new Errno(data,"成功",0);
    }
}
