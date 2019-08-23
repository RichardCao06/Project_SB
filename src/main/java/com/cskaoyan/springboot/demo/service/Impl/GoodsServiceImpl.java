package com.cskaoyan.springboot.demo.service.Impl;

import com.cskaoyan.springboot.demo.Vo.DataResult;
import com.cskaoyan.springboot.demo.Vo.ResponseVo;
import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.mapper.GoodsMapper;
import com.cskaoyan.springboot.demo.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MatthewLi on 2019/8/20
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public ResponseVo<DataResult<Goods>> queryAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Goods> goods = goodsMapper.queryAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        int total =(int)pageInfo.getTotal();
        DataResult<Goods> dataResult =new DataResult<>();
        dataResult.setItems(goods);
        dataResult.setTotal(total);
        ResponseVo<DataResult<Goods>> responseVo =new ResponseVo<>();
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        responseVo.setData(dataResult);
       /* ResponseVo<DataResult<Goods>> responseVo = new ResponseVo<>(dataResult, "成功", 0);*/
        return responseVo;
    }

    @Override
    public ResponseVo<DataResult<Goods>> fuzzyQuery(int page, int limit, String goodsSn, String name) {
        PageHelper.startPage(page, limit);
        List<Goods> goods = goodsMapper.fuzzyQuery("%" + goodsSn + "%", "%" + name + "%");
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        int total =(int)pageInfo.getTotal();
        DataResult<Goods> dataResult =new DataResult<>();
        dataResult.setItems(goods);
        dataResult.setTotal(total);
        ResponseVo<DataResult<Goods>> responseVo =new ResponseVo<>();
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        responseVo.setData(dataResult);
        /*ResponseVo<DataResult<Goods>> responseVo = new ResponseVo<>(dataResult, "成功", 0);*/
        return responseVo;
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public Goods queryOneById(int id) {
        return goodsMapper.queryOneById(id);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int delete(Goods goods) {
        return goodsMapper.delete(goods);
    }
}
