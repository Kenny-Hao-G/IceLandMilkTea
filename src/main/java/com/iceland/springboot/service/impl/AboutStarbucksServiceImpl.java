package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.AboutStarbucksMapper;
import com.iceland.springboot.pojo.AboutStarbucks;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.service.AboutStarbucksService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AboutStarbucksServiceImpl extends ServiceImpl<AboutStarbucksMapper,AboutStarbucks> implements AboutStarbucksService {
    @Override
    public List<AboutStarbucks> getAboutStarbucksList() {
        return getBaseMapper().selectList(new QueryWrapper<AboutStarbucks>());
    }
}
