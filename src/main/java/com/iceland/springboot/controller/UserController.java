package com.iceland.springboot.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/24  20:49
 */
@RestController
@Api(tags = "用于用户登录，注册，修改等操作")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    @ApiOperation("注册")
    public Result register(User user){

        return Result.setResult(userService.register(user),"注册");
    }

    @PostMapping("/user/login")
    @ApiOperation("登录")
    public Result login(User user){
        return Result.setResult(userService.login(user),"登录");
    }



    @DeleteMapping("/user/delete")
    public Result delete(int id){
        return Result.setResult(userService.removeById(id),"删除");
    }

    /*@PutMapping("/user/update")
    public Result update(User user){
       return Result.setResult(userService.updateByUserEmail(user));
    }*/
}
