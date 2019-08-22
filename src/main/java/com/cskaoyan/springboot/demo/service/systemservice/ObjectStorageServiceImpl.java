package com.cskaoyan.springboot.demo.service.systemservice;

import com.cskaoyan.springboot.demo.bean.Picture;
import com.cskaoyan.springboot.demo.bean.Storage;
import com.cskaoyan.springboot.demo.bean.systembean.ResponseVo;
import com.cskaoyan.springboot.demo.bean.systembean.SystemRole2;
import com.cskaoyan.springboot.demo.mapper.StorageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.cskaoyan.springboot.demo.util.FileUpload.pictureUpload;

@Service
public class ObjectStorageServiceImpl implements ObjectStorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public ResponseVo getStorageList(int page,int limit) {
        PageHelper.startPage(page,limit);
        List<Storage> storages = storageMapper.getAllStorage();
        PageInfo<Storage> pageInfo = new PageInfo<>(storages);
        SystemRole2<List<Storage>> role2 = new SystemRole2<>();
        role2.setItems(storages);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo updateStorage(Storage storage) {
        int i = storageMapper.updateById(storage.getName(), storage.getId());
        ResponseVo<Storage> responseVo = new ResponseVo<>();
        if(i == 1){
            responseVo.setErrno(0);
        }else {
           responseVo.setErrmsg("失败");
        }responseVo.setErrmsg("成功");
        responseVo.setData(storage);
        return responseVo;
    }

    @Override
    public ResponseVo deleteStorage(Storage storage) {
        int i = storageMapper.deleteByPrimaryKey(storage.getId());
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if(i == 1){
            responseVo.setErrmsg("成功");

        }else {
            responseVo.setErrmsg("失败");
        }
        responseVo.setErrno(0);
        return responseVo;
    }

    @Override
    public ResponseVo searchStorage(int page,int limit,String key,String name) {
        PageHelper.startPage(page,limit);
        name = "%" + name + "%";
        key = "%" + key+ "%";
        List<Storage> storages = storageMapper.searchByNameAndKey(key, name);
        PageInfo<Storage> pageInfo = new PageInfo<>(storages);
        SystemRole2<List<Storage>> role2 = new SystemRole2<>();
        role2.setItems(storages);
        role2.setTotal((int) pageInfo.getTotal());
        ResponseVo<SystemRole2> responseVo = new ResponseVo<>();
        responseVo.setData(role2);
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;

    }

    @Override
    public ResponseVo fileUpload(MultipartFile file) {
        Picture picture = new Picture();
        try {
            picture = pictureUpload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseVo<Picture> responseVo = new ResponseVo<>();

        int i = storageMapper.insertPic(picture);
        if(i == 1){
            responseVo.setErrmsg("成功");
        }
        responseVo.setData(picture);
        responseVo.setErrno(0);
        return responseVo;
    }
}
