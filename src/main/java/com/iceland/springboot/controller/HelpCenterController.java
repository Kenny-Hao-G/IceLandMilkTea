package com.iceland.springboot.controller;


import com.iceland.springboot.service.HelpCenterService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "帮助中心",tags = "帮助中心")
public class HelpCenterController {
    @Autowired
    HelpCenterService helpCenterService;
    @GetMapping("/getHelpCenterList")
    @ApiOperation(value = "获取菜单列表",notes = "获取菜单列表")
    public Result getHelpCenterList() {
        return helpCenterService.getHelpCenterList();

    }

    @GetMapping("/getDetailedInformation")
    @ApiOperation(value = "菜单ID获取详细信息",notes = "菜单ID获取详细信息")
    public Result getDetailedInformation(int id) {
        return helpCenterService.getDetailedInformation(id);

    }

    @GetMapping("/getProvince")
    @ApiOperation(value = "获取省份",notes = "获取省份")
    public Result getProvince() {
        return helpCenterService.getProvince();

    }

    @GetMapping("/getCity")
    @ApiOperation(value = "获取城市",notes = "获取城市")
    public Result getCity(Integer id) {
        return helpCenterService.getCity(id);

    }

    @GetMapping("/getStoresInformation")
    @ApiOperation("获取门店信息")
    public Result getStoresInformation(Integer id) {
        return helpCenterService.getStoresInformation(id);



    }
}
