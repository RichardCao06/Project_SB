package com.cskaoyan.springboot.demo.controller.mall;

import com.cskaoyan.springboot.demo.bean.mall.MessageWithData;
import com.cskaoyan.springboot.demo.bean.Storage;
import com.cskaoyan.springboot.demo.service.mallService.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("admin")
public class StorageController {
    @Autowired
    MallService mallService;

   /* @RequestMapping("storage/create")
    public MessageWithData storeFile(MultipartFile file) throws IOException {
        //根据上传的文件生成文件信息
        Storage storageFile = mallService.createUploadFileData(file);
        System.out.println(storageFile.getUrl());
        //将fileData数据储存入数据库
        mallService.addStorage(storageFile);
        System.out.println(storageFile);
        //文件存储路径
        String path = "D:\\tupian";
        File receiveFile = new File(path,storageFile.getKey());
        file.transferTo(receiveFile);
        MessageWithData messageWithData = new MessageWithData();
        messageWithData.setErrno(0);
        messageWithData.setErrmsg("成功");
        messageWithData.setData(storageFile);
        return messageWithData;
    }*/
}
