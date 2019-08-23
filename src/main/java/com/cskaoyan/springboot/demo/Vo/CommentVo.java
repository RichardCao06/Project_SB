package com.cskaoyan.springboot.demo.Vo;

import com.cskaoyan.springboot.demo.bean.Comment;

/**
 * Created by MatthewLi on 2019/8/19
 */
public class CommentVo extends Comment {
    private String commentId;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
