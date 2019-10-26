package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.AboutStarbucks;
import com.iceland.springboot.pojo.BakingWorkShop;
import com.iceland.springboot.pojo.HelpCenterMenu;

import java.util.List;

public interface BakingWorkShopService extends IService<BakingWorkShop> {
    List<BakingWorkShop> getBakingWorkShopList();

}
