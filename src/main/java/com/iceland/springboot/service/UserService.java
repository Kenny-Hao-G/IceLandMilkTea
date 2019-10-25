package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.vo.ForgetPassword;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/24  20:58
 */
public interface UserService extends IService<User> {

    boolean register(User user);

    boolean login(User user);

    boolean forgetPassword(ForgetPassword forgetPassword);
}
