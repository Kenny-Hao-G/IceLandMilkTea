package com.iceland.springboot.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/24  20:49
 */
@Api(value = "用户Controller", tags = "用户Controller")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public Result register(User user) {

        return Result.setResult(userService.register(user), "注册");
    }


    @DeleteMapping("/user/delete")
    public Result delete(int id) {
        return Result.setResult(userService.removeById(id), "删除");
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
