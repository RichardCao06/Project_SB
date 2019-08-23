package com.cskaoyan.springboot.demo.controller.popularize;

import com.cskaoyan.springboot.demo.bean.Ad;
import com.cskaoyan.springboot.demo.bean.popularize.Errmsg;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.service.popularize.AdService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdController {
    @Autowired
    AdService adService;
    @RequestMapping("ad/list")
    @ResponseBody
    public Object list(String name,String content, Integer page,Integer limit){

        ResponVo<Ad> adResponVo=adService.list(name,content,page, limit);

        return new Errmsg(adResponVo,"成功",0);

    }
    @RequestMapping("ad/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Ad ad) {
        Map<String, Object> map = new HashMap<>();
        adService.update(ad);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", ad);

        return map;
    }
    @ResponseBody
    @RequestMapping("/ad/create")
    public Map<String,Object> create(@RequestBody Ad ad){
        Map<String, Object> map = new HashMap<>();
        if (ad.getLink()==null)
            ad.setLink("");
        adService.create(ad);
        map.put("errno",0);
        map.put("errmsg","成功");
        map.put("data",ad);
        return map;
    }

    @RequestMapping("ad/delete")
    @ResponseBody
    public Map<String,Object> delete(@RequestBody Ad ad){
        Map<String, Object> map = new HashMap<>();
        adService.delect(ad);
        map.put("errno",0);
        map.put("errmsg","成功");
        return map;
    }
}
