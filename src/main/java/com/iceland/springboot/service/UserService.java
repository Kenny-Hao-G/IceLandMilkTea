package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.vo.ForgetPassword;
import io.swagger.models.auth.In;

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
     * @param userId 页面传入的值
     * @return
     */
    User queryUserInfo(Integer userId);



    boolean login(User user);

    boolean forgetPassword(ForgetPassword forgetPassword);

    /**
     * 修改用户名
     *
     * @param username 传入的用户名
     * @return
     */
    Integer modifyUsername(User username);

    /**
     * 修改用户邮箱
     *
     * @param userEmail
     * @return
     */
    Integer modifyUserEmail(User userEmail);

    /**
     * 修改用户邮箱
     *
     * @param userPassword 电话号码
     * @param id 用户 id
     * @return
     */
    boolean security(Integer id,String userPassword);

    boolean queryUserPassword(Integer id, String userPassword);
}
