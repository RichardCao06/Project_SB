package com.cskaoyan.springboot.demo.mapper;

import com.cskaoyan.springboot.demo.bean.Goods;
import com.cskaoyan.springboot.demo.bean.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> getListRecord(@Param("sort") String sort, @Param("order")String order,@Param("goodsId") String goodsId);

/*````````````````````````````````````````````````````````````````````````````````````````````````````*/



    List<Goods> queryAll();

    List<Goods> fuzzyQuery(@Param("goodsSn") String goodsSn, @Param("name") String name);

    int insertGoods(Goods goods);

    Goods queryOneById(int id);

    int update(@Param("goods") Goods goods);

    int delete(@Param("goods") Goods goods);
}