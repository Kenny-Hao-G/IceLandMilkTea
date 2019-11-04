package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.WorkChanceMapper;
import com.iceland.springboot.pojo.WorkChance;
import com.iceland.springboot.service.WorkChanceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkChanceServiceImpl extends ServiceImpl<WorkChanceMapper, WorkChance> implements WorkChanceService {
    @Override
    public List<WorkChance> getWorkChanceList() {
        return getBaseMapper().selectList(new QueryWrapper<WorkChance>());
    }
}
