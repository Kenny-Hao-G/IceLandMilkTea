package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/24  20:53
 */
@Data
@TableName("user_info")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String userPhoneNumber;

    private String userEmail;

    private String userAddress;

    private String userBirthday;

    private String userSex;

    private String userHeadPortrait;
    private String userPassword;


}
