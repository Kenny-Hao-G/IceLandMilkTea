package com.iceland.springboot.controller;

import com.iceland.springboot.service.GoodsService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value = "获取菜单信息",tags = "获取菜单信息")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/menu")
    @ApiOperation(value = "获取一级菜单信息",notes = "获取一级菜单信息")
    public Result getMenu() {
        List menu = goodsService.getMenu();
        if (menu != null) {
            return Result.setOK(menu);
        }else {
            return Result.setERROR();
        }
    }

    @GetMapping("/kindMenu")
    @ApiOperation(value = "获取二级菜单信息",notes = "获取二级菜单")
    public Result getKindMenu(int id) {
        List kindMenu = goodsService.getKindMenu(id);
        if (kindMenu != null) {
            return Result.setOK(kindMenu);
        }else {
            return Result.setERROR();
        }

    }




}
