package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.service.HelpCenterService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "帮助中心",tags = "帮助中心")
public class HelpCenterController {
    @Autowired
    HelpCenterService helpCenterService;
    @GetMapping("/getHelpCenterList")
    @ApiOperation(value = "获取菜单列表",notes = "获取菜单列表")
    public Result getHelpCenterList() {
        List<HelpCenterMenu> list = helpCenterService.getHelpCenterList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }
}
