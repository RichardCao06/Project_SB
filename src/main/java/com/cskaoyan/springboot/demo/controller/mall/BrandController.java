package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.Brand;
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
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping("brand/list")
    public BrandMessage showBrandList(int page, int limit, String sort, String order){
        BrandMessage brandMessage = new BrandMessage();
        BrandData brandData = new BrandData();
        //System.out.println(page);
        //查询brandList的分页数据
        List<Brand> brandList = mallService.findBrandListByPage(page, limit);
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
}
