package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.pojo.HelpCenterProblem;

import java.util.List;

public interface HelpCenterService extends IService<HelpCenterMenu> {
    List<HelpCenterMenu> getHelpCenterList();

    List<HelpCenterProblem> getDetailedInformation(int id);
}
