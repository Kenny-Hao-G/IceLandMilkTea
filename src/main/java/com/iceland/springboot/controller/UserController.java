package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.ForgetPassword;
import com.iceland.springboot.vo.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
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
    public Result register(User user) {

        return Result.setResult(userService.register(user), "注册");
    }

    @PostMapping("/user/login")
    @ApiOperation("登录")
    public Result login(User user) {
        return Result.setResult(userService.login(user), "登录");
    }


    @DeleteMapping("/user/delete")
    public Result delete(int id) {
        return Result.setResult(userService.removeById(id), "删除");
    }

    @PostMapping("/user/forgetPassword")
    public Result forgetPassword(ForgetPassword forgetPassword) {
        return Result.setResult(userService.forgetPassword(forgetPassword), "忘记密码");
    }

    /**
     * 进入修改用户信息页面，先查询用户信息
     * 根据id 查询用户信息
     *
     * @param userId 传入的 id
     * @return
     */
    @ApiOperation(value = "通过 id 查询用户信息", notes = "通过 id 查询用户信息")
    @GetMapping("/user/queryUseInfoById")
    public Result queryUserInfo(Integer userId) {
        return Result.setOK(userService.queryUserInfo(userId));
    }

    /**
     * 页面传入一个 id 值，获取一个 id 下的 username
     * 随后更改 username
     *
     * @param userId Integer 类型数据
     * @return
     */
    @GetMapping("/user/queryUsername")
    @ApiOperation(value = "通过 id 查询当前 username", notes = "通过 id 查询当前 username")
    public Result queryUsername(Integer userId) {
        return Result.setOK(userService.queryUserInfo(userId));
    }

    /**
     * 修改用户名
     *
     * @param username
     * @return
     */
    @PostMapping("/user/modifyUsername")
    @ApiOperation(value = "通过 id 修改用户名", notes = "通过 id 修改用户名")
    public Result modifyUsername(User username) {
        System.out.println("保存的 username 为: " + username);
        Integer result = userService.modifyUsername(username);
        return Result.setOK(result);
    }

    /**
     * 修改邮箱
     *
     * @param userEmail 邮箱
     * @return
     */
    @PostMapping("/user/modifyEmail")
    @ApiOperation(value = "通过 id 修改邮箱", notes = "通过 id 修改邮箱")
    public Result modifyUserEmail(User userEmail) {
        System.out.println("保存的邮箱为: " + userEmail);
        Integer result = userService.modifyUserEmail(userEmail);
        return Result.setOK(result);
    }

    /**
     * 显示用户手机号
     * 不可更改用户手机号
     *
     * @return
     */
    @GetMapping("/user/showPhoneNum")
    @ApiOperation(value = "显示用户手机号", notes = "显示用户手机号")
    public Result showUserPhoneNumber(Integer userId) {
        return Result.setOK(userService.queryUserInfo(userId));
    }

    /**
     * 更改用户密码
     *
     * @return
     */
    @PostMapping("/user/modifyOldPwd")
    @ApiOperation(value = "更改旧密码", notes = "更改旧密码")
    public Result modifyOldPwd(Integer id, String userPassword) {
        return Result.setOK(userService.security(id, userPassword));
    }

    /**
     * 当用户更改密码时
     * 需要验证旧密码来保证安全性
     *
     * @param id
     * @param userPassword
     * @return
     */
    @GetMapping("/user/queryPwd")
    @ApiOperation(value = "查询旧密码", notes = "查询旧密码")
    public Result queryUserPassword(Integer id, String userPassword) {
        boolean result = userService.queryUserPassword(id, userPassword);
        if (result) {
            return Result.setOK(result);
        } else {
            return Result.setERROR();
        }
    }
}
