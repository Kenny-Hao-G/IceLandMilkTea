package com.iceland.springboot.dao;


import com.iceland.springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    @Select("select count(1) from user_info i,user_password p where i.user_name=#{username} or i.user_phone_number=#{phone} " +
            "and p.user_password=#{password} and p.fk_user_id = i.user_id")
    int login(User user);

}
