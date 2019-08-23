package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.Vo.DataResult;
import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Comment;
import com.cskaoyan.springboot.demo.mapper.CommentMapper;
import com.cskaoyan.springboot.demo.service.CommentService;
import com.cskaoyan.springboot.demo.wx.bean.CommentWx;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MatthewLi on 2019/8/17
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public ResponseVo selectComment(int page, int limit, String userId, String valueId, String sort, String order) {
        ResponseVo responseVo =new ResponseVo();
        DataResult<Comment> data = new DataResult<>();
        PageHelper.startPage(page,limit);
        if (userId == ""){
            userId = null;
        }
        if (valueId == ""){
            valueId = null;
        }
        List<Comment> comments = commentMapper.selectComment(sort, order,userId, valueId);
        data.setItems(comments);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        data.setTotal((int) pageInfo.getTotal());
        responseVo.setData(data);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    @Override
    public ResponseVo deleteComment(Comment comment) {
        ResponseVo responseVo =new ResponseVo();
        int i = commentMapper.deleteComment(comment);
        if (i == 1){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }
        return responseVo;
    }

    @Override
    public List<CommentWx> getCommentsByGoodsId(int goodsId) {
        return commentMapper.getCommentsByGoodsId(goodsId);
    }

    @Override
    public int getCommentCountByGoodsId(int goodsId) {
        return commentMapper.getCommentCountByGoodsId(goodsId);
    }

}

