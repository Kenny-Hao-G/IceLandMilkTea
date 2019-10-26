package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.AboutStarbucks;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.service.AboutStarbucksService;
import com.iceland.springboot.service.HelpCenterService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "关于星巴克",tags = "关于星巴克")
public class AboutStarbucksController {
    @Autowired
    AboutStarbucksService aboutStarbucksService;
    @GetMapping("/getAboutStarbucksList")
    @ApiOperation(value = "关于星巴克",notes = "关于星巴克")
    public Result getAboutStarbucksList() {
        List<AboutStarbucks> list = aboutStarbucksService.getAboutStarbucksList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }
}
