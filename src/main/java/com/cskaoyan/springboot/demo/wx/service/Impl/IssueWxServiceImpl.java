package com.cskaoyan.springboot.demo.wx.service.Impl;

import com.cskaoyan.springboot.demo.bean.Issue;
import com.cskaoyan.springboot.demo.mapper.IssueMapper;
import com.cskaoyan.springboot.demo.wx.service.IssueWxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MatthewLi on 2019/8/22
 */
@Service
public class IssueWxServiceImpl implements IssueWxService {

    @Resource
    IssueMapper issueMapper;

    @Override
    public List<Issue> getAllIssue() {
        return issueMapper.getAllIssue();
    }
}
