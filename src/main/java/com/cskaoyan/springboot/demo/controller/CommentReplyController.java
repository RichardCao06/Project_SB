package com.cskaoyan.springboot.demo.controller;

import com.cskaoyan.springboot.demo.Vo.CommentVo;
import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MatthewLi on 2019/8/19
 */
@RestController
public class CommentReplyController {

    @Autowired
    CommentReplyService commentReplyService;

    @RequestMapping("admin/order/reply")
    public ResponseVo reply(@RequestBody CommentVo commentVo){
        return commentReplyService.insertCommentContent(commentVo.getCommentId(),commentVo.getContent());
    }
}
