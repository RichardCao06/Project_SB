package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by MatthewLi on 2019/8/19
 */
public interface CommentReplyService {
     ResponseVo insertCommentContent(@Param("id") String commentId, @Param("content") String content);

}
