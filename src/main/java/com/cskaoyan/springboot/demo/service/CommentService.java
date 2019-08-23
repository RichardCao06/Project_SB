package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Comment;
import com.cskaoyan.springboot.demo.wx.bean.CommentWx;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/17
 */
public interface CommentService {

    //获取信息
    ResponseVo selectComment(int page, int limit, String sort, String order, String userId, String valueId);

    //删除评论
    ResponseVo deleteComment(Comment comment);

    List<CommentWx> getCommentsByGoodsId(int goodsId);

    int getCommentCountByGoodsId(int goodsId);
}
