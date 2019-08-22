package com.cskaoyan.springboot.demo.util;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.springboot.demo.bean.Picture;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class FileUpload {

    public static Picture pictureUpload(MultipartFile file) throws IOException {
        Picture picture = new Picture();
        //oss核心参数
        InputStream inputStream = file.getInputStream();
        String secretKey = "LTAIlK6Jk40IVwml";
        String secret = "zlWh2n7TkOMBG1rtTSIRyfdHpoODvh";
        String bucket = "ljgcskaoyan";
        String endPoint = "oss-cn-beijing.aliyuncs.com";

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        String filename = file.getOriginalFilename();
        String name =  UUID.randomUUID().toString().replaceAll("-","");

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket,name,inputStream,objectMetadata);
        OSSClient ossClient = new OSSClient(endPoint, secretKey, secret);
        ossClient.putObject(putObjectRequest);

        picture.setUrl("https://" + bucket + "." + endPoint + "/" + name);
        picture.setName(filename);
        picture.setKey(name);
        picture.setType(file.getContentType());
        picture.setSize(file.getSize());
        picture.setAddTime(new Date());
        picture.setUpdateTime(new Date());
        return picture;

    }
}
