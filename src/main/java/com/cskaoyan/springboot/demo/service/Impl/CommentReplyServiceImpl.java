package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.mapper.CommentMapper;
import com.cskaoyan.springboot.demo.service.CommentReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by MatthewLi on 2019/8/19
 */
@Service
public class CommentReplyServiceImpl implements CommentReplyService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public ResponseVo insertCommentContent(String commentId, String content) {
        ResponseVo responseVo = new ResponseVo();
        int i = commentMapper.insertCommentContent(commentId,content);
        if(i==1){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else {
            responseVo.setErrmsg("订单商品已回复！");
            responseVo.setErrno(622);
        }

        return responseVo;
    }
}
