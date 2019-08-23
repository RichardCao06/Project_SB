package com.cskaoyan.springboot.demo.controller;


import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Comment;
import com.cskaoyan.springboot.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MatthewLi on 2019/8/17
 */
@RestController
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/list")
    public ResponseVo commentList(int page, int limit, String sort, String order, String userId, String valueId){
        return commentService.selectComment(page, limit, sort, order, userId, valueId);
    }

    @PostMapping("/delete")
    public ResponseVo delete(@RequestBody Comment comment){
        ResponseVo responseVo = commentService.deleteComment(comment);
        return responseVo;
    }

}
