package com.cskaoyan.springboot.demo.service;

import com.cskaoyan.springboot.demo.Vo.DataResult;
import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Goods;

/**
 * Created by MatthewLi on 2019/8/20
 */
public interface GoodsService {

    ResponseVo<DataResult<Goods>> queryAll(int page, int limit);

    ResponseVo<DataResult<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name);

    int insertGoods(Goods goods);

    Goods queryOneById(int id);

    int update(Goods goods);

    int delete(Goods goods);

}
