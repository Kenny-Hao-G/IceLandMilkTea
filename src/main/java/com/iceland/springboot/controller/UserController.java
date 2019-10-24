package com.iceland.springboot.controller;


import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "实现冰岛的各种操作",tags = "实现冰岛的各种操作")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "实现登录功能",notes = "实现登录功能")
    @PostMapping("user/login.do")
    public Result login(User user){

        return userService.login(user);
    }

}
