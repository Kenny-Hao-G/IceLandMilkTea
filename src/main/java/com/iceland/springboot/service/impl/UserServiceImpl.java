package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.UserMapper;
import com.iceland.springboot.pojo.User;
import com.iceland.springboot.service.UserService;
import com.iceland.springboot.utils.MailUtils;
import com.iceland.springboot.utils.Md5Utils;
import com.iceland.springboot.vo.ForgetPassword;
import com.iceland.springboot.vo.Result;
import io.swagger.models.auth.In;
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

        if (user.getUserEmail() != null || user.getUserName() != null || user.getUserPhoneNumber() != null) {
            user.setUserPassword(Md5Utils.getMd5Str(user.getUserPassword()));
            if (user.getUserEmail() != null) {
                User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_email", user.getUserEmail()));
                if (Objects.equals(user1.getUserPassword(), user.getUserPassword())) {
                    Subject subject = SecurityUtils.getSubject();

                    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserEmail(), user.getUserPassword());
                    subject.getSession().setAttribute("USERNAME", user);
                    subject.login(token);
                    return true;

                }

            }
            if (user.getUserPhoneNumber() != null) {
                User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_phone_number", user.getUserPhoneNumber()));
                if (Objects.equals(user1.getUserPassword(), user.getUserPassword())) {
                    Subject subject = SecurityUtils.getSubject();

                    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserPhoneNumber(), user.getUserPassword());
                    subject.getSession().setAttribute("USERNAME", user);
                    subject.login(token);
                    return true;

                }

            }
            if (user.getUserName() != null) {
                User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("user_name", user.getUserName()));
                if (Objects.equals(user1.getUserPassword(), user.getUserPassword())) {
                    Subject subject = SecurityUtils.getSubject();

                    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
                    subject.getSession().setAttribute("USERNAME", user);
                    subject.login(token);
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
     * @param userId 页面传入的值
     * @return
     */
    @Override
    public User queryUserInfo(Integer userId) {
        return userMapper.queryUserInfoById(userId);
    }


    @Override
    public boolean forgetPassword(ForgetPassword forgetPassword) {
        if (forgetPassword.getUserPhoneNumber() != null) {

        }

        if (forgetPassword.getUserEmail() != null) {

            String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
            MailUtils.sendMail(forgetPassword.getUserEmail(), "验证码请勿泄露！", code);
            User user = new User();
            user.setUserEmail(forgetPassword.getUserEmail());
            user.setCode(code);
            int count = getBaseMapper().updateByEmail(user);

            return count > 0 ? true : false;

        }
        return false;
    }

    /**
     * 修改用户名
     *
     * @param username 传入的用户名
     * @return
     */
    @Override
    public Integer modifyUsername(User username) {
        return userMapper.modifyUsername(username);
    }

    /**
     * 修改用户邮箱
     *
     * @param userEmail 传入的邮箱名
     * @return
     */
    @Override
    public Integer modifyUserEmail(User userEmail) {
        return userMapper.modifyUserEmail(userEmail);
    }

    /**
     * 根据用户 id 修改密码
     *
     * @param id           用户 id
     * @param userPassword 电话号码
     * @return
     */
    @Override
    public boolean security(Integer id, String userPassword) {
        User user = new User();
        user.setUserId(id);
        user.setUserPassword(Md5Utils.getMd5Str(userPassword));
        int result = userMapper.modifyUserPhoneNum(user);
        return result > 0 ? true : false;
    }

    @Override
    public boolean queryUserPassword(Integer id, String userPassword) {
        User user = new User();
        user.setUserId(id);
        user.setUserPassword(Md5Utils.getMd5Str(userPassword));
        int result = userMapper.queryUserPassword(user);
        return result > 0 ? true : false;
    }
}
