package com.iceland.springboot.pojo;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String birthday;
    private String sex;
    private String headPortrait;
}
