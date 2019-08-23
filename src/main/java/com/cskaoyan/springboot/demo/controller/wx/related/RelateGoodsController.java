package com.cskaoyan.springboot.demo.controller.wx.related;



import com.cskaoyan.springboot.demo.bean.Goods;
//mport com.cskaoyan.springboot.demo.bean.wx.goods.Errno;
import com.cskaoyan.springboot.demo.bean.wx.related.Errno;
//import com.cskaoyan.springboot.demo.service.goods.GoodsService;
import com.cskaoyan.springboot.demo.service.related.RelateGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("wx")
public class RelateGoodsController {


    @Autowired
    RelateGoodsService relateGoodsService;



    /**
     * 获得推荐的六个商品
     * @param id
     * @return
     */
    @RequestMapping("goods/related")
    public Errno relatedCommend(Integer id){
        Errno errno = new Errno();
            errno.setErrmsg("成功");
            errno.setErrno(0);
        List<Goods> goods = relateGoodsService.selectGoodsByCategoryID(id);

        //截取前六个，不足六个则全部返回
        if (goods.size() < 6){
            //errno.setGoodsList(goods);
            errno.setGoodsList(goods);
        }else {
            goods.subList(0,5);
            errno.setGoodsList(goods);
        }
        return errno;
    }


}
