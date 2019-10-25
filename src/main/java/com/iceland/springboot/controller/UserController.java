package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.ForgetPassword;
import com.iceland.springboot.vo.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user/forgetPassword")
    public Result forgetPassword(ForgetPassword forgetPassword) {
        return Result.setResult(userService.forgetPassword(forgetPassword), "忘记密码");
    }
    /**
     * 进入修改用户信息页面，先查询用户信息
     * 根据id 查询用户信息
     *
     * @param id 传入的 id
     * @return
     */
    @ApiOperation(value = "通过 id 查询用户信息", notes = "通过 id 查询用户信息")
    @GetMapping("/user/queryUseInfoById")
    public Result queryUserInfo(Integer id) {
        return Result.setOK(userService.queryUserInfo(id));

    }


}
