package com.example.analysisshop.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class User implements Serializable {


    private static final long serialVersionUID = -6471228043670654129L;

    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    //@Range(min = 0,max = 120,message = "年龄要在正常范围内")
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
