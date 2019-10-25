package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.User;
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
    boolean register( User user);
    @Insert("insert into iceland_milk_tea.user_info ( user_phone_number, user_password) values (#{userPhoneNumber},#{userPassword})")
    @ResultType(Boolean.class)
    boolean registerByPhoneNumber(User user);

    @Update("update iceland_milk_tea.user_info set code=#{code} where user_email=#{userEmail}")
    @ResultType(Integer.class)
    int updateByEmail(User user);

    /**
     * 进入修改用户信息页面，先查询用户信息
     * 根据id 查询用户信息
     *
     * @param id 页面传入的值
     * @param id
     * @return
     */
    @Select("SELECT us.user_name, us.user_email, us.user_phone_number, us.user_password " +
            "FROM iceland_milk_tea.user_info us " +
            "WHERE us.user_id = #{id}")
    User queryUserInfoById(Integer id);

    String modifyUsername(String username);
}
