package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.StarClass;

import java.util.List;

public interface StarClassService extends IService<StarClass> {
    List<StarClass> getStarClassList();

}
