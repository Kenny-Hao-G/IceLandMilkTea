package com.iceland.springboot.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.Result;

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
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public Result register(User user){

        return Result.setResult(userService.register(user),"注册");
    }



    @DeleteMapping("/user/delete")
    public Result delete(int id){
        return Result.setResult(userService.removeById(id),"删除");
    }


}
