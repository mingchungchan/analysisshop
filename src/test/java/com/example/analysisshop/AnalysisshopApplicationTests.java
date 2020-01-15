package com.example.analysisshop;

import com.example.analysisshop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AnalysisshopApplication.class})// 指定启动类
public class AnalysisshopApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        System.out.println("asdasdasda");
    }

}
