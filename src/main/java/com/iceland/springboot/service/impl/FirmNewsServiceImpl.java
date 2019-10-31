package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.FirmNewsMapper;
import com.iceland.springboot.pojo.FirmNews;
import com.iceland.springboot.service.FirmNewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmNewsServiceImpl extends ServiceImpl<FirmNewsMapper, FirmNews> implements FirmNewsService {
    @Override
    public List<FirmNews> getFirmNewsList() {
        return getBaseMapper().selectList(new QueryWrapper<FirmNews>());
    }
}
