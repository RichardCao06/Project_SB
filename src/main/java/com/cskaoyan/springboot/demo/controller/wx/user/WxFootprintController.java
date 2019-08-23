package com.cskaoyan.springboot.demo.controller.wx.user;


import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.bean.user.Errno;
import com.cskaoyan.springboot.demo.bean.user.WxFootPrint;
import com.cskaoyan.springboot.demo.realm.UserTokenManager;
import com.cskaoyan.springboot.demo.service.wx.user.WxFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("wx/footprint")
public class WxFootprintController {
    @Autowired
    WxFootprintService wxFootprintService;

    @RequestMapping("list")
    public Object list(int page, int size, HttpServletRequest request){
        //userID
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //查询
        PageBean<WxFootPrint> pageBean = wxFootprintService.findByUserId(page, size, userId);
        //组装
        HashMap<String, Object> data = new HashMap<>();
        data.put("footprintList",pageBean.getItems());
        data.put("totalPages",pageBean.getTotal());
        return new Errno(data,"成功",0);
    }
}
