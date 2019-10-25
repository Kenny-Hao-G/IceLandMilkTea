package com.iceland.springboot.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.HelpCenterMapper;
import com.iceland.springboot.pojo.Address;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.pojo.HelpCenterProblem;
import com.iceland.springboot.pojo.StoresInformation;
import com.iceland.springboot.service.HelpCenterService;
import com.iceland.springboot.vo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpCenterServiceImpl extends ServiceImpl<HelpCenterMapper, HelpCenterMenu> implements HelpCenterService {

    @Override
    public Result getHelpCenterList() {
        List<HelpCenterMenu> list = getBaseMapper().selectList(new QueryWrapper<HelpCenterMenu>());
        if (list.size() > 0) {
            return Result.setOK(list);
        }else {
            return Result.setERROR();
        }
    }

    @Override
    public Result getDetailedInformation(int id) {
        List<HelpCenterProblem> list = getBaseMapper().getDetailedInformation(id);
        if (list.size() > 0) {
            return Result.setOK(list);
        }else {
            return Result.setERROR();
        }
    }

    @Override
    public Result getProvince() {
        List<Address> list = getBaseMapper().getProvince();
        if (list.size() > 0) {
            return Result.setOK(list);
        }else {
            return Result.setERROR();
        }
    }

    @Override
    public Result getCity(int id) {
        List<Address> list = getBaseMapper().getCity(id);
        if (list.size() > 0) {
            return Result.setOK(list);
        }else {
            return Result.setERROR();
        }
    }

    @Override
    public Result getStoresInformation(int id) {
        List<StoresInformation> list = getBaseMapper().getStoresInformation(id);
        if (list.size() > 0) {
            return Result.setOK(list);
        }else {
            return Result.setERROR();
        }
    }
}
