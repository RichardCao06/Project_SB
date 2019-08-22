package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Storage;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageService {

    ResponseVo getStorageList(int page, int limit);

    ResponseVo updateStorage(Storage storage);

    ResponseVo deleteStorage(Storage storage);

    ResponseVo searchStorage(int page, int limit, String key, String name);

    ResponseVo fileUpload(MultipartFile file);
}
