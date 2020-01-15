package com.example.analysisshop.mapper;

import com.example.analysisshop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    List<User> getAllUser();

    //用户登录
    User userlogin(@Param("username") String username, @Param("password") String password);

    //注册新用户(方式1)
    int adduser(@Param("user") User user);

}
