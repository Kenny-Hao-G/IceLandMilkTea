package com.iceland.springboot.service.impl;


import com.iceland.springboot.dao.UserMapper;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Result login(User user) {
        if (userMapper.login(user) > 0) {
            return Result.setOK("登录成功");
        } else {
            return Result.setERROR();
        }
    }

    @Override
    public Result register(User user) {
        if (userMapper.register(user)>0) {
            return Result.setOK("注册成功");
        } else {
            return Result.setERROR();
        }
    }
}
