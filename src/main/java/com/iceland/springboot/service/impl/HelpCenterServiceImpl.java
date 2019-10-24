package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.HelpCenterMapper;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.service.HelpCenterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpCenterServiceImpl extends ServiceImpl<HelpCenterMapper, HelpCenterMenu> implements HelpCenterService {

    @Override
    public List<HelpCenterMenu> getHelpCenterList() {
        return getBaseMapper().selectList(new QueryWrapper<HelpCenterMenu>());
    }
}
