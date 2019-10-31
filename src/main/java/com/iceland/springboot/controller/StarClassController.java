package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.StarClass;
import com.iceland.springboot.service.StarClassService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "星讲堂",tags = "星讲堂")
public class StarClassController {
    @Autowired
    StarClassService starClassService;
    @GetMapping("/getStarClassList")
    @ApiOperation(value = "星讲堂",notes = "星讲堂")
    public Result getStarClassList() {
        List<StarClass> list = starClassService.getStarClassList();
        if (list != null) {
            return Result.setOK(list);
        }
        return Result.setERROR();
    }
}
