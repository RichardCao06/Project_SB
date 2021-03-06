package com.cskaoyan.springboot.demo.controller;


import com.cskaoyan.springboot.demo.Vo.DataResult;
import com.cskaoyan.springboot.demo.Vo.OperationVO;
import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.*;
import com.cskaoyan.springboot.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by MatthewLi on 2019/8/20
 */
@RestController
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    EchoBrandAndCatService echoBrandAndCatService;
    @Autowired
    ProductService productService;
    @Autowired
    SpecificationService specificationService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AttributeService attributeService;

    //查询商品列表
    @RequestMapping("/list")
    @ResponseBody
    public ResponseVo getGoodsList(int page, int limit, String goodsSn, String name, String sort, String order) {
        if (goodsSn == null && name == null) {
            ResponseVo<DataResult<Goods>> responseVo = goodsService.queryAll(page, limit);
            return responseVo;
        } else {
            if (goodsSn == null) {
                goodsSn = "";
            } else if (name == null) {
                name = "";
            }
            ResponseVo<DataResult<Goods>> responseVo = goodsService.fuzzyQuery(page, limit, goodsSn, name);
            return responseVo;
        }
    }

    //新增商品
    //品牌和目录的回显
    @RequestMapping("/catAndBrand")
    @ResponseBody
    public ResponseVo echoBrandAndCat() {
        List<SpecificItem> brandList = echoBrandAndCatService.echoBrand();
        List<CategorySpecific> categoryList = echoBrandAndCatService.echoCategory();
        EchoBrandAndCat echoBrandAndCat = new EchoBrandAndCat(brandList, categoryList);
        ResponseVo<EchoBrandAndCat> responseVo = new ResponseVo<>(echoBrandAndCat, "成功", 0);
        return responseVo;
    }

    //新增操作的执行
    @RequestMapping("/create")
    @ResponseBody
    public OperationVO doInsert(@RequestBody GoodsInsert goodsInsert) {
        List<Attribute> attributes = goodsInsert.getAttributes();
        Goods goods = goodsInsert.getGoods();
        List<Product> products = goodsInsert.getProducts();
        List<Specification> specifications = goodsInsert.getSpecifications();
        //插入goods
        goods.setOnSale(true);
        goods.setNew(true);
        goods.setHot(false);
        goods.setDeleted(false);
        Date now = new Date();
        goods.setAddTime(now);
        goods.setUpdateTime(now);
        //insert1-->goods插入返回的结果
        //insert2-->product插入返回的结果
        //insert3-->specification插入返回的结果
        //insert4-->specification插入返回的结果
        int insert1 = goodsService.insertGoods(goods);
        int insert2 = 0;
        int insert3 = 0;
        int insert4 = 0;
        int goodsId = goods.getId();
        //插入product
        for (Product product : products) {
            product.setGoodsId(goodsId);
            product.setAddTime(now);
            product.setUpdateTime(now);
            product.setDeleted(false);
            insert2 = productService.insert(product);
        }
        //插入specification
        for (Specification specification : specifications) {
            specification.setAddTime(now);
            specification.setUpdateTime(now);
            specification.setDeleted(false);
            specification.setGoodsId(goodsId);
            insert3 = specificationService.insertSelective(specification);
        }
        //插入attribute
        for (Attribute attribute : attributes) {
            attribute.setGoodsId(goodsId);
            attribute.setAddTime(now);
            attribute.setUpdateTime(now);
            insert4 = attributeService.insertSelective(attribute);

        }
        OperationVO operationVO = null;
        if (insert1 ==1 && insert2 ==1 && insert3 == 1 && insert4 == 1) {
            operationVO = new OperationVO(0, "成功");
        } else {
            operationVO = new OperationVO(401, "参数不对");
        }
        return operationVO;
    }

    //编辑商品
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseVo echoGoods(int id) {
        Goods goods = goodsService.queryOneById(id);
        int categoryId1 = goods.getCategoryId();
        int categoryId2 = categoryService.queryPidById(categoryId1);
        int[] categoryIds =  new int[]{categoryId2, categoryId1};
        List<Attribute> attributes = attributeService.queryByGoodsId(id);
        List<Product> products = productService.queryByGoodsId(id);
        List<Specification> specifications = specificationService.queryByGoodsId(id);
        GoodsDetail goodsDetail = new GoodsDetail(attributes, categoryIds, goods, products, specifications);
        ResponseVo<GoodsDetail> responseVo = new ResponseVo<>(goodsDetail, "成功", 0);
        return responseVo;
    }

    //执行编辑操作
    @RequestMapping("/update")
    @ResponseBody
    public OperationVO doUpdate(@RequestBody GoodsInsert goodsInsert) {
        List<Attribute> attributes = goodsInsert.getAttributes();
        Goods goods = goodsInsert.getGoods();
        List<Product> products = goodsInsert.getProducts();
        List<Specification> specifications = goodsInsert.getSpecifications();
        //插入goods
        Date now = new Date();
        goods.setUpdateTime(now);
        //insert1-->goods插入返回的结果
        //insert2-->product插入返回的结果
        //insert3-->specification插入返回的结果
        //insert4-->specification插入返回的结果
        int update1 = goodsService.update(goods);
        int update2 = 0;
        int update3 = 0;
        int update4 = 0;
        int goodsId = goods.getId();
        //更新product
        for (Product product : products) {
            if (product.getId() == null || product.getId() == 0) {
                product.setGoodsId(goodsId);
                product.setAddTime(now);
                product.setUpdateTime(now);
                product.setDeleted(false);
                update2 = productService.insert(product);
            } else {
                product.setUpdateTime(now);
                update2 = productService.updateByPrimaryKey(product);
            }
        }

        //删除已经去掉了的product
        List<Product> productList = productService.queryByGoodsId(goodsId);
        for (Product item : productList) {
            //作为标记，0表示item已经不存在，1表示item还存在
            int flag = 0;
            for (Product product : products) {
                if (item.getId().intValue() == product.getId().intValue()) {
                    flag = 1;
                    break;
                }
            }
            //item已不存在，删除数据库中对应的项
            if (flag == 0) {
                update2 = productService.deleteByPrimaryKey(item.getId());
            }
        }
        //更新specification
        for (Specification specification : specifications) {
            if (specification.getId() == null || specification.getId() == 0) {
                specification.setAddTime(now);
                specification.setUpdateTime(now);
                specification.setDeleted(false);
                specification.setGoodsId(goodsId);
                update3 = specificationService.insertSelective(specification);
            } else {
                specification.setUpdateTime(now);
                update3 = specificationService.updateByPrimaryKey(specification);
            }
        }
        //删除已经去掉了的specification
        List<Specification> specificationList = specificationService.queryByGoodsId(goodsId);
        for (Specification item : specificationList) {
            int flag = 0;
            for (Specification specification : specifications) {
                /*System.out.println("a:" + specification.getId().intValue());
                System.out.println("b:" + item.getId().intValue());*/
                if (specification.getId().intValue() == item.getId().intValue()) {
                    flag = 1;
                    break;
                }
            }
            //item已不存在，执行删除
            if (flag == 0) {
                update3 = specificationService.deleteByPrimaryKey(item.getId());
            }

        }
        //更新attribute
        for (Attribute attribute : attributes) {
            if (attribute.getId() == null || attribute.getId() == 0) {
                attribute.setGoodsId(goodsId);
                attribute.setAddTime(now);
                attribute.setUpdateTime(now);
                update4 = attributeService.insertSelective(attribute);
            } else {
                attribute.setUpdateTime(now);
                update4 = attributeService.updateByPrimaryKey(attribute);
            }
        }
        //删除已经去掉的attribute
        List<Attribute> attributeList = attributeService.queryByGoodsId(goodsId);
        for (Attribute item : attributeList) {
            int flag = 0;
            for (Attribute attribute : attributes) {
                /*System.out.println("a:" + specification.getId().intValue());
                System.out.println("b:" + item.getId().intValue());*/
                if (attribute.getId().intValue() == item.getId().intValue()) {
                    flag = 1;
                    break;
                }
            }
            //item已不存在，执行删除
            if (flag == 0) {
                update4 = attributeService.deleteByPrimaryKey(item.getId());
            }
        }

        OperationVO operationVO = null;
        if (update1 == 1 && update2 == 1 && update3 == 1 && update4 == 1) {
            operationVO = new OperationVO(0, "成功");
        } else {
            operationVO = new OperationVO(401, "参数不对");
        }
        return operationVO;

    }

    //删除商品
    @RequestMapping("/delete")
    @ResponseBody
    public OperationVO doDelete(@RequestBody Goods goods) {
        OperationVO operationVO;
        int delete = goodsService.delete(goods);
        if (delete == 1) {
            operationVO = new OperationVO(0, "成功");
        } else {
            operationVO = new OperationVO(401, "删除失败");
        }
        return operationVO;

    }



}
