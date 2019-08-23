package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Issue;
import com.cskaoyan.springboot.demo.bean.IssueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueMapper {
    long countByExample(IssueExample example);

    int deleteByExample(IssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    int queryIssueById();

    /*``````````````````````*/
    List<Issue> getAllIssue();
}