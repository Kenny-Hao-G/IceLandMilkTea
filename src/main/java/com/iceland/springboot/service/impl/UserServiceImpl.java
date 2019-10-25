package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.UserMapper;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.utils.Md5Utils;
import com.iceland.springboot.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/24  20:59
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        if (user.getUserPhoneNumber() != null) {
            user.setUserPassword(Md5Utils.getMd5Str(user.getUserPassword()));
            return userMapper.registerByPhoneNumber(user);
        }
        if (user.getUserEmail() != null) {
            user.setUserPassword(Md5Utils.getMd5Str(user.getUserPassword()));
            return userMapper.register(user);
        }
        return false;


    }

    @Override
    public boolean login(User user) {

        if (user.getUserEmail() != null || user.getUserName() != null || user.getUserPhoneNumber() != null){
            user.setUserPassword(Md5Utils.getMd5Str(user.getUserPassword()));
            if (user.getUserEmail() != null) {
                User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_email", user.getUserEmail()));
                if (Objects.equals(user1.getUserPassword(), user.getUserPassword())) {
                    Subject subject = SecurityUtils.getSubject();

                    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserEmail(), user.getUserPassword());
                    subject.getSession().setAttribute("USERNAME", user);
                    return true;

                }

            }
        if (user.getUserPhoneNumber() != null) {
            User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_phone_number", user.getUserPhoneNumber()));
            if (Objects.equals(user1.getUserPassword(), user.getUserPassword())) {
                Subject subject = SecurityUtils.getSubject();

                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserPhoneNumber(), user.getUserPassword());
                subject.getSession().setAttribute("USERNAME", user);
                return true;

            }

        }
        if (user.getUserName() != null) {
            User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_name", user.getUserName()));
            if (Objects.equals(user1.getUserPassword(), user.getUserPassword())) {
                Subject subject = SecurityUtils.getSubject();

                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
                subject.getSession().setAttribute("USERNAME", user);
                return true;

            }

        }
        }
        if (user.getUserPhoneNumber() == null && user.getUserName() == null && user.getUserEmail() == null) {
            return false;
        }
        return false;


    }

    /**
     * 进入修改用户信息页面，先查询用户信息
     * 根据id 查询用户信息
     *
     * @param id 页面传入的值
     * @return
     */
    @Override
    public User queryUserInfo(Integer id) {
        return userMapper.queryUserInfoById(id);
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public String modifyUsername(String username) {
        return userMapper.modifyUsername(username);

    }
}
