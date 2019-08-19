package com.cskaoyan.springboot.demo.controller;

import com.cskaoyan.springboot.demo.bean.Issue;
import com.cskaoyan.springboot.demo.bean.IssueBean;
import com.cskaoyan.springboot.demo.bean.IssueVo;
import com.cskaoyan.springboot.demo.bean.KeywordData;
import com.cskaoyan.springboot.demo.service.IssueService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("issue/list")
    @ResponseBody
    public IssueVo findKeyword(String question, int page, int limit){

        List<Issue> issueList =  issueService.findIssue(question,page, limit);
        PageInfo<Issue> pageInfo = new PageInfo<>(issueList);

        KeywordData data = new KeywordData();
        data.setItems(issueList);
        data.setTotal(pageInfo.getTotal());
        IssueVo issueVo = new IssueVo();
        issueVo.setData(data);
        issueVo.setErrmsg("成功");
        issueVo.setErrno(0);

        return issueVo;
    }

    @RequestMapping("issue/update")
    @ResponseBody
    public IssueVo update(@RequestBody Issue issue){

        IssueVo issueVo = new IssueVo();
        issue =  issueService.update(issue);
        issueVo.setIssue(issue);
        issueVo.setErrmsg("成功");
        issueVo.setErrno(0);
        return issueVo;
    }

    @RequestMapping("issue/create")
    @ResponseBody
    public IssueBean create(@RequestBody Issue issue){

        Issue select = issueService.insert(issue);
        IssueBean issueBean = new IssueBean();
        issueBean.setData(select);
        issueBean.setErrmsg("成功");
        issueBean.setErrno(0);

        return issueBean;

    }

    @RequestMapping("issue/delete")
    @ResponseBody
    public IssueVo delete(@RequestBody Issue issue){

        issueService.delete(issue);

        IssueVo issueVo = new IssueVo();
        issueVo.setIssue(issue);
        issueVo.setErrmsg("成功");
        issueVo.setErrno(0);
        return issueVo;

    }
}
