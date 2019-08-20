package com.cskaoyan.springboot.demo.mapper.mall;

import com.cskaoyan.springboot.demo.bean.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageListMapper {
    int insertStorage(@Param("storage") Storage storage);
}
