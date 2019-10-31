package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.WorkChance;

import java.util.List;

public interface WorkChanceService extends IService<WorkChance> {
    List<WorkChance> getWorkChanceList();
}
