package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.WorksMapper;
import com.iceland.springboot.pojo.Works;
import com.iceland.springboot.service.WorksService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorksServiceImpl extends ServiceImpl<WorksMapper, Works> implements WorksService {
    @Override
    public List<Works> getWorksList() {
            return getBaseMapper().selectList(new QueryWrapper<Works>());
        }
    }

