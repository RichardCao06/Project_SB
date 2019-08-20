package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Issue;
import com.cskaoyan.springboot.demo.bean.IssueExample;
import com.cskaoyan.springboot.demo.mapper.IssueMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    @Resource
    IssueMapper issueMapper;

    @Override
    public List<Issue> findIssue(String question, int page, int limit) {
        IssueExample example = new IssueExample();
        IssueExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(question)){
            criteria.andQuestionLike("%" + question + "%");
        }
        PageHelper.startPage(page, limit);
        return issueMapper.selectByExample(example);
    }

    @Override
    public Issue update(Issue issue) {
        issue.setUpdateTime(LocalDateTime.now());
        issueMapper.updateByPrimaryKey(issue);
        Issue select = issueMapper.selectByPrimaryKey(issue.getId());
        return select;
    }

    @Override
    public Issue insert(Issue issue) {
        issue.setAddTime(LocalDateTime.now());
        issue.setUpdateTime(LocalDateTime.now());
        issueMapper.insertSelective(issue);
        int id = issueMapper.queryIssueById();
        Issue select = issueMapper.selectByPrimaryKey(id);
        return select;
    }

    @Override
    public void delete(Issue issue) {

        issueMapper.deleteByPrimaryKey(issue.getId());
    }
}
