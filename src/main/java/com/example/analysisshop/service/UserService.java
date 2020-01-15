package com.example.analysisshop.service;

import com.example.analysisshop.entity.User;
import com.example.analysisshop.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public User userlogin(String username, String password) {
        return userMapper.userlogin(username,password);
    }

    public int adduser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.adduser(user);
        return user.getId();
    }


    public List<User> search() {
        return userMapper.selectAll();
    }


}
