package com.example.analysisshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

//表明mapper所在
@MapperScan("com.example.analysisshop.mapper")
@SpringBootApplication
@EnableTransactionManagement   //开启事务管理
public class AnalysisshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalysisshopApplication.class, args);
    }



}
