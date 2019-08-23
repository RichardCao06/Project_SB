package com.cskaoyan.springboot.demo.controller.popularize;

import com.cskaoyan.springboot.demo.bean.Topic;
import com.cskaoyan.springboot.demo.bean.popularize.ResponVo;
import com.cskaoyan.springboot.demo.service.popularize.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import java.util.Map;
@Controller
@RequestMapping("admin")
public class TopicController {
    @Autowired
    TopicService topicService;
 /*/admin/topic/list?page=1&limit=20&sort=add_time&order=desc*/
@RequestMapping("topic/list")
    @ResponseBody public Map<String,Object> list(int page,int limit,String sort,String order,String title,String subtitle){
    Map<String,Object> map=new HashMap();
    ResponVo<Topic> topicResponVo =topicService.list(page,limit,sort,order,title,subtitle);
    map.put("data",topicResponVo);
    map.put("errmsg","成功");
    map.put("errno",0);
    return map;
}
    @RequestMapping("topic/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Topic topic) {
        Map<String, Object> map = new HashMap<>();
        topicService.update(topic);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", topic);

        return map;
    }
    @ResponseBody
    @RequestMapping("/topic/create")
    public Map<String,Object> create(@RequestBody Topic topic){
        Map<String, Object> map = new HashMap<>();

        topicService.create(topic);
        map.put("errno",0);
        map.put("errmsg","成功");
        map.put("data",topic);
        return map;
    }

    @RequestMapping("topic/delete")
    @ResponseBody
    public Map<String,Object> delete(@RequestBody Topic topic){
        Map<String, Object> map = new HashMap<>();
        topicService.delect(topic);
        map.put("errno",0);
        map.put("errmsg","成功");
        return map;
    }

}
