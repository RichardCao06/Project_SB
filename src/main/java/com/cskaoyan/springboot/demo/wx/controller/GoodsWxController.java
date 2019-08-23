package com.cskaoyan.springboot.demo.wx.controller;

import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.service.*;
import com.cskaoyan.springboot.demo.wx.bean.CommentWx;
import com.cskaoyan.springboot.demo.wx.bean.GoodsDetailWx;
import com.cskaoyan.springboot.demo.wx.bean.SpecificationWx;
import com.cskaoyan.springboot.demo.wx.service.BrandService;
import com.cskaoyan.springboot.demo.wx.service.GrouponService;
import com.cskaoyan.springboot.demo.wx.service.IssueWxService;
import com.cskaoyan.springboot.demo.wx.vo.BaseRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by MatthewLi on 2019/8/22
 */
@RestController
@RequestMapping("/wx/goods")
public class GoodsWxController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    AttributeService attributeService;
    @Autowired
    BrandService brandService;
    @Autowired
    CommentService commentService;
    @Autowired
    GrouponService grouponService;
    @Autowired
    IssueWxService issueService;
    @Autowired
    ProductService productService;
    @Autowired
    SpecificationService specificationService;
    @Autowired
    CategoryService categoryService;


    //商品详情
    @RequestMapping("/detail")
    public BaseRespVO goodsDetail(Integer id){
        GoodsDetailWx data = getGoodsDetailById(id);
        BaseRespVO baseRespVO =BaseRespVO.ok(data);
        return baseRespVO;
    }

    private GoodsDetailWx getGoodsDetailById(int goodsId) {
        GoodsDetailWx goodsDetailWx = new GoodsDetailWx();
        Goods goods =goodsService.queryOneById(goodsId);
        //Attribute
        List<Attribute> attribute =attributeService.getAttributeByGoodsId(goodsId);

        //Brand
        Brand brand = null;
        if (goods.getBrandId() != 0 && goods.getBrandId() != null){
            brand = brandService.getBrandById(goods.getBrandId());
        }

        //Comment
        HashMap<String, Object> comment = new HashMap<>();
        List<CommentWx> comments = commentService.getCommentsByGoodsId(goodsId);
        int count = commentService.getCommentCountByGoodsId(goodsId);
        comment.put("data",comments);
        comment.put("count", count);

        //Groupon
        List<Groupon> groupon = grouponService.getGrouponRulesByGoodsId(goodsId);

        //Info
        Goods info = goodsService.queryOneById(goodsId);

        //Issue
        List<Issue> issue = issueService.getAllIssue();

        //Product
        List<Product> productList = productService.queryByGoodsId(goodsId);

        //ShareImage
        String shareImage = "";

        //SpecificationList
        List<SpecificationWx> specificationList = specificationService.querySpecificationWxByGoodsId(goodsId);

        //userHasCollect，需userId


        goodsDetailWx.setAttribute(attribute);
        goodsDetailWx.setBrand(brand);
        goodsDetailWx.setComment(comment);
        goodsDetailWx.setGroupon(groupon);
        goodsDetailWx.setInfo(info);
        goodsDetailWx.setIssue(issue);
        goodsDetailWx.setProductList(productList);
        goodsDetailWx.setShareImage(shareImage);
        goodsDetailWx.setSpecificationList(specificationList);
        return goodsDetailWx;
    }




}
