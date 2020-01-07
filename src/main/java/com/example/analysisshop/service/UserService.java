package com.example.analysisshop.service;

import com.example.analysisshop.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUser();

    //用户登录
    User userlogin(String username, String password);

    //注册新用户(方式1)
    int adduser(String username,String password);


}
