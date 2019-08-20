package com.cskaoyan.springboot.demo.bean;

public class IssueVo {

    private KeywordData data;
    private int errno;
    private String errmsg;
    private Issue issue;

    public KeywordData getData() {
        return data;
    }

    public void setData(KeywordData data) {
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "IssueVo{" +
                "data=" + data +
                ", errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", issue=" + issue +
                '}';
    }
}
