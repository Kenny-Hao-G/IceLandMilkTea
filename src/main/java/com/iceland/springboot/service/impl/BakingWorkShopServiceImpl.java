package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.iceland.springboot.dao.BakingWorkShopMapper;
import com.iceland.springboot.pojo.BakingWorkShop;
import com.iceland.springboot.service.BakingWorkShopService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BakingWorkShopServiceImpl extends ServiceImpl<BakingWorkShopMapper, BakingWorkShop> implements BakingWorkShopService {

    @Override
    public List<BakingWorkShop> getBakingWorkShopList() {
        return getBaseMapper().selectList(new QueryWrapper<BakingWorkShop>());
    }
}
