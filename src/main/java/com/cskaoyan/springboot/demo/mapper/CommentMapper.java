package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Comment;
import com.cskaoyan.springboot.demo.bean.CommentExample;
import java.util.List;

import com.cskaoyan.springboot.demo.wx.bean.CommentWx;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);


    List<Comment> selectComment(@Param("userId") String userId,@Param("valueId") String valueId, @Param("sort") String sort, @Param("orderby") String order);

    int deleteComment(@Param("comment") Comment comment);

    int insertCommentContent(String commentId,String content);

    List<CommentWx> getCommentsByGoodsId(@Param("goodsId") int goodsId);

    int getCommentCountByGoodsId(@Param("goodsId") int goodsId);
}