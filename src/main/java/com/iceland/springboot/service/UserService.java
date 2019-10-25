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

    /**
     * 进入修改用户信息页面，先查询用户信息
     * 根据id 查询用户信息
     *
     * @param id 页面传入的值
     * @return
     */
     User queryUserInfo(Integer id);

    /**
     * 点击编辑后更改用户名
     *
     * @param username
     * @return
     */
     String modifyUsername(String username);

    boolean login(User user);

    boolean forgetPassword(ForgetPassword forgetPassword);
}
