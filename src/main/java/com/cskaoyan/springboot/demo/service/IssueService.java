package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.bean.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> findIssue(String question, int page, int limit);

    Issue update(Issue issue);

    Issue insert(Issue issue);

    void delete(Issue issue);
}
