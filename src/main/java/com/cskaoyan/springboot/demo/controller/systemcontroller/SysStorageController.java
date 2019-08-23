package com.cskaoyan.springboot.demo.controller.systemcontroller;

import com.cskaoyan.springboot.demo.bean.Storage;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.service.systemservice.ObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("admin")
public class SysStorageController {

    @Autowired
    ObjectStorageService objectStorageService;

    @RequestMapping("storage/list")
    public ResponseVo storage(int page, int limit, String name, String key, String sort, String order){
        if(name != null || key != null){
            return objectStorageService.searchStorage(page,limit,key,name);
        }
        return objectStorageService.getStorageList(page,limit);
    }

    @RequestMapping("storage/update")
    public ResponseVo update(@RequestBody Storage storage){
        return objectStorageService.updateStorage(storage);
    }

    @RequestMapping("storage/delete")
    public ResponseVo delete(@RequestBody Storage storage){
        return objectStorageService.deleteStorage(storage);
    }

    @RequestMapping("storage/create")
    public ResponseVo picUpload(MultipartFile file){
        return objectStorageService.fileUpload(file);
    }



}
