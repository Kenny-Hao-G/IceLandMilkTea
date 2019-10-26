package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.AboutStarbucks;
import com.iceland.springboot.pojo.BakingWorkShop;
import com.iceland.springboot.service.AboutStarbucksService;
import com.iceland.springboot.service.BakingWorkShopService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "上海烘焙工坊",tags = "上海烘焙工坊")
public class BakingWorkShopController {
    @Autowired
    BakingWorkShopService bakingWorkShopService;
    @GetMapping("/getBakingWorkShopList")
    @ApiOperation(value = "上海烘焙工坊",notes = "上海烘焙工坊")
    public Result getBakingWorkShopList() {
        List<BakingWorkShop> list = bakingWorkShopService.getBakingWorkShopList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }
}
