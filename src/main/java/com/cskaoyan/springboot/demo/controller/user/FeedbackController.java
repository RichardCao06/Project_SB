package com.cskaoyan.springboot.demo.controller.user;


import com.cskaoyan.springboot.demo.bean.Errno;
import com.cskaoyan.springboot.demo.bean.Feedback;
import com.cskaoyan.springboot.demo.bean.PageBean;
import com.cskaoyan.springboot.demo.service.user.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("list")
    public Object list(int page,int limit,Integer id,String username,String sort,String order){
        PageBean<Feedback> feedbacks = feedbackService.findByCondition(page, limit, username, id, sort, order);
        return new Errno<>(feedbacks,"成功",0);
    }
}
