package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.StarClassMapper;
import com.iceland.springboot.pojo.StarClass;
import com.iceland.springboot.service.StarClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarClassServiceImpl extends ServiceImpl<StarClassMapper, StarClass> implements StarClassService {
    @Override
    public List<StarClass> getStarClassList() {
        return getBaseMapper().selectList(new QueryWrapper<StarClass>());
    }
}
