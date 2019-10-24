package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.ResultType;
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
}
