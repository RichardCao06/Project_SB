package com.cskaoyan.springboot.demo.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;

import com.cskaoyan.springboot.demo.bean.OssParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUploadController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    OssParam ossParam;
    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String contentType = file.getContentType();
        long size = file.getSize();
        //oss 四个核心参数
        String bucket = ossParam.getBucket();
        String endPoint = "oss-cn-beijing.aliyuncs.com";
        String secretKey = "LTAI8EgTxlc4QQZr";
        String secret = "RBDvSGZOR8DaUJxlLrW4Ed46RVnAkR";
        String fileName = UUID.randomUUID().toString().replaceAll("-","");
        logger.info("文件名：" + fileName);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(size);
        objectMetadata.setContentType(contentType);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, fileName, inputStream, objectMetadata);
        OSSClient ossClient = new OSSClient(endPoint, secretKey, secret);
        ossClient.putObject(putObjectRequest);


        return "ok";
    }
    @RequestMapping("index")
    public String index(){

        return "index";
    }
}
