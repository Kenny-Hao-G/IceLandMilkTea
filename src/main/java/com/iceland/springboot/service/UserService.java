package com.iceland.springboot.service;



import com.iceland.springboot.pojo.User;
import com.iceland.springboot.vo.Result;

public interface UserService {
    Result login(User user);

    Result register(User user);
}
