package com.example.analysisshop.serviceImpl;

import com.example.analysisshop.entity.User;
import com.example.analysisshop.mapper.UserMapper;
import com.example.analysisshop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User userlogin(String username, String password) {
        User user = userMapper.userlogin(username,password);
        return user;
    }

    @Override
    public int adduser(String username, String password) {
        return userMapper.adduser(username,password);
    }
}