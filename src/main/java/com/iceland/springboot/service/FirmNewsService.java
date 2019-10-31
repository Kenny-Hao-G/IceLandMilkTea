package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.FirmNews;

import java.util.List;

public interface FirmNewsService extends IService<FirmNews> {
    List<FirmNews> getFirmNewsList();
}
