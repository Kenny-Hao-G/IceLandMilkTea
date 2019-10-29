package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.vo.Result;



public interface HelpCenterService extends IService<HelpCenterMenu> {
    Result getHelpCenterList();

    Result getDetailedInformation(int id);

    Result getProvince();

    Result getCity(int id);

    Result getStoresInformation(int id);
}
