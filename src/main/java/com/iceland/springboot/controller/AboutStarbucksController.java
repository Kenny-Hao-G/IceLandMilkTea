package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.*;
import com.iceland.springboot.service.*;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "关于星巴克",tags = "关于星巴克")
public class AboutStarbucksController {
    @Autowired
    AboutStarbucksService aboutStarbucksService;
    @Autowired
    FirmNewsService firmNewsService;
    @Autowired
    WorkChanceService workChanceService;
    @Autowired
    WorksService worksService;

    @GetMapping("/getAboutStarbucksList")
    @ApiOperation(value = "关于星巴克")
    public Result getAboutStarbucksList() {
        List<AboutStarbucks> list = aboutStarbucksService.getAboutStarbucksList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }

    @GetMapping("/getFirmNewsList")
    @ApiOperation(value = "企业新闻",notes = "企业新闻")
    public Result getFirmNewsList() {
        List<FirmNews> list = firmNewsService.getFirmNewsList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }
    @GetMapping("/getWorkChanceList")
    @ApiOperation(value = "工作机会",notes = "工作机会")
    public Result getWorkChanceList() {
        List<WorkChance> list = workChanceService.getWorkChanceList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }

    @PostMapping("/getWorksList")
    @ApiOperation(value = "选择工作方式",notes = "选择工作方式")
    public Result getWorksList() {
        List<Works> list = worksService.getWorksList();
        if (list != null) {

            return Result.setOK(list);
        }
        
        return Result.setERROR();
    }

}
