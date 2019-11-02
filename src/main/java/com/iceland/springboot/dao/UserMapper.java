package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/24  21:00
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into iceland_milk_tea.user_info ( user_email, user_password) values (#{userEmail},#{userPassword})")
    @ResultType(Boolean.class)
    boolean register(User user);

    @Insert("insert into iceland_milk_tea.user_info ( user_phone_number, user_password) values (#{userPhoneNumber},#{userPassword})")
    @ResultType(Boolean.class)
    boolean registerByPhoneNumber(User user);

    @Update("update iceland_milk_tea.user_info set code=#{code} where user_email=#{userEmail}")
    @ResultType(Integer.class)
    int updateByEmail(User user);

    /**
     * 根据id 查询用户信息
     *
     * @param userId 页面传入的值
     * @return
     */
    @Select("SELECT * " +
            "FROM iceland_milk_tea.user_info us " +
            "WHERE us.user_id = #{userId}")
    @ResultType(User.class)
    User queryUserInfoById(Integer userId);


    /**
     * 修改用户名
     *
     * @param username 用户名
     * @return
     */
    @Update("UPDATE user_info SET user_name = #{userName} WHERE user_id = #{userId}")
    @ResultType(Integer.class)
    Integer modifyUsername(User username);

    /**
     * 修改邮箱
     *
     * @param userEmail 邮箱
     * @return
     */
    @Update("UPDATE user_info SET user_email = #{userEmail} WHERE user_id = #{userId}")
    @ResultType(Integer.class)
    Integer modifyUserEmail(User userEmail);

    /**
     * 显示用户手机号
     *
     * @param userId 通过 userId 查询用户手机号
     * @return
     */
    @Select("SELECT ui.user_id, ui.user_phone_number " +
            "FROM user_info ui " +
            "WHERE ui.user_id = #{userId}")
    String queryUserPhoneNum(Integer userId);

    /**
     * 更改用户手机号
     *
     * @param userPassword 用户手机号
     * @return
     */
    @Update("UPDATE user_info SET user_password = #{userPassword} WHERE user_id = #{userId}")
    int modifyUserPhoneNum(User userPassword);

    /**
     * 显示用户手机号
     *
     * @param userPassword 通过 userId 查询用户手机号
     * @return
     */
    @Select("SELECT COUNT(1) " +
            "FROM user_info " +
            "WHERE user_id = #{userId} and user_password = #{userPassword}")
    int queryUserPassword(User userPassword);
}
