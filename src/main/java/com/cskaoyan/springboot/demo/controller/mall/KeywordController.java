package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.Keyword;
import com.cskaoyan.springboot.demo.bean.KeywordBean;
import com.cskaoyan.springboot.demo.bean.KeywordData;
import com.cskaoyan.springboot.demo.bean.KeywordVo;
import com.cskaoyan.springboot.demo.service.KeywordService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    @RequestMapping("keyword/list")
    @ResponseBody
    public KeywordVo findKeyword(String keyword, String url, int page, int limit){

        List<Keyword> keywordList =  keywordService.findKeyword(keyword,url,page, limit);
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywordList);

        KeywordData data = new KeywordData();
        data.setItems(keywordList);
        data.setTotal(pageInfo.getTotal());
        KeywordVo keywordVo = new KeywordVo();
        keywordVo.setData(data);
        keywordVo.setErrmsg("成功");
        keywordVo.setErrno(0);
        return keywordVo;
    }

    @RequestMapping("keyword/update")
    @ResponseBody
    public KeywordBean update(@RequestBody Keyword keyword){

        keyword =  keywordService.update(keyword);

        KeywordBean keywordBean = new KeywordBean();
        keywordBean.setData(keyword);
        keywordBean.setErrmsg("成功");
        keywordBean.setErrno(0);
        return keywordBean;
    }

    @RequestMapping("keyword/create")
    @ResponseBody
    public KeywordBean create(@RequestBody Keyword keyword){

        Keyword select = keywordService.insert(keyword);

        KeywordBean keywordBean = new KeywordBean();
        keywordBean.setData(select);
        keywordBean.setErrmsg("成功");
        keywordBean.setErrno(0);
        return keywordBean;

    }

    @RequestMapping("keyword/delete")
    @ResponseBody
    public KeywordVo delete(@RequestBody Keyword keyword){

       keywordService.delete(keyword);

        KeywordVo keywordVo = new KeywordVo();
        keywordVo.setErrmsg("成功");
        keywordVo.setErrno(0);
        return keywordVo;

    }

}
