package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.Works;

import java.util.List;

public interface WorksService  extends IService<Works> {
    List<Works> getWorksList();

}
