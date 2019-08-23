package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.mall.BrandCondition;
import com.cskaoyan.springboot.demo.bean.mall.DataWithItemAndTotal;
import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class BrandController {

    @Autowired
    MallService mallService;


    /**
     * 分页展示品牌商数据
     * @return
     */
    @RequestMapping("brand/list")
    public MessageWithData showBrandList(BrandCondition brandCondition){
        //注意id可能为空，所以需设置为Integer而不是int，int无法接受null值
        MessageWithData messageWithData = new MessageWithData();
        DataWithItemAndTotal dataWithItemAndTotal = new DataWithItemAndTotal();
        //查询brandList的分页数据
        //List<Brand> brandList = mallService.findBrandListByPage(page, limit);
        List<Brand> brandList = mallService.findBrandListByIdByName(brandCondition.getPage(), brandCondition.getLimit(), brandCondition.getId(), brandCondition.getName());
        //查询brandList总数
        int count = mallService.countBrandList();
        if(brandList != null){
            //将查询结果封装入返回的message信息中
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            dataWithItemAndTotal.setItems(brandList);
            dataWithItemAndTotal.setTotal(count);
            messageWithData.setData(dataWithItemAndTotal);
            return messageWithData;
        }
        return null;
    }

    @RequestMapping("brand/update")
    public MessageWithData updateBrand(@RequestBody Brand brand){
        MessageWithData messageWithData = new MessageWithData();
        int num = mallService.updateBrand(brand);
        Brand brandResult = mallService.findBrandById(brand.getId());
        if(num != 0){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            messageWithData.setData(brandResult);
            return messageWithData;
        }
        return null;
    }

    @RequestMapping("brand/create")
    public MessageWithData createBrand(@RequestBody Brand brand){
        MessageWithData messageWithData = new MessageWithData();
        int num = mallService.insertBrand(brand);
        if(num > 0){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            return messageWithData;
        }
        return null;
    }

    /**
     * 删除brand数据
     * @param brand
     * @return
     */
    @RequestMapping("brand/delete")
    public MessageWithData deleteBrand(@RequestBody Brand brand){
        MessageWithData messageWithData = new MessageWithData();
        int num = mallService.deleteBrandById(brand.getId());
        if(num > 0){
            messageWithData.setErrno(0);
            messageWithData.setErrmsg("成功");
            return messageWithData;
        }
        return null;
    }
}
