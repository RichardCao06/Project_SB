package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.Brand;
import com.cskaoyan.springboot.demo.bean.mall.BrandCondition;
import com.cskaoyan.springboot.demo.bean.mall.BrandData;
import com.cskaoyan.springboot.demo.bean.mall.BrandMessage;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    MallService mallService;


    /**
     * 分页展示品牌商数据
     * @return
     */
    @RequestMapping("brand/list")
    public BrandMessage showBrandList(BrandCondition brandCondition){
        //注意id可能为空，所以需设置为Integer而不是int，int无法接受null值
        BrandMessage brandMessage = new BrandMessage();
        BrandData brandData = new BrandData();
        //查询brandList的分页数据
        //List<Brand> brandList = mallService.findBrandListByPage(page, limit);
        List<Brand> brandList = mallService.findBrandListByIdByName(brandCondition.getPage(), brandCondition.getLimit(), brandCondition.getId(), brandCondition.getName());
        //查询brandList总数
        int count = mallService.countBrandList();
        if(brandList != null){
            //将查询结果封装入返回的message信息中
            brandMessage.setErrno(0);
            brandMessage.setErrmsg("成功");
            brandData.setItems(brandList);
            brandData.setTotal(count);
            brandMessage.setData(brandData);
            return brandMessage;
        }
        return null;
    }

    @RequestMapping("brand/update")
    public BrandMessage updateBrand(@RequestBody Brand brand){
        BrandMessage brandMessage = new BrandMessage();
        int num = mallService.updateBrand(brand);
        Brand brandResult = mallService.findBrandById(brand.getId());
        if(num != 0){
            brandMessage.setErrno(0);
            brandMessage.setErrmsg("成功");
            brandMessage.setData(brandResult);
            return brandMessage;
        }
        return null;
    }

    @RequestMapping("brand/create")
    public BrandMessage createBrand(@RequestBody Brand brand){
        BrandMessage brandMessage = new BrandMessage();
        int num = mallService.insertBrand(brand);
        if(num > 0){
            brandMessage.setErrno(0);
            brandMessage.setErrmsg("成功");
            return brandMessage;
        }
        return null;
    }

    /**
     * 删除brand数据
     * @param brand
     * @return
     */
    @RequestMapping("brand/delete")
    public BrandMessage deleteBrand(@RequestBody Brand brand){
        BrandMessage brandMessage = new BrandMessage();
        int num = mallService.deleteBrandById(brand.getId());
        if(num > 0){
            brandMessage.setErrno(0);
            brandMessage.setErrmsg("成功");
            return brandMessage;
        }
        return null;
    }
}
