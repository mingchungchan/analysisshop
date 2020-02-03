package com.example.analysisshop;

import com.example.analysisshop.entity.Items;
import com.example.analysisshop.service.ItemsService;
import com.example.analysisshop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AnalysisshopApplication.class})// 指定启动类
public class AnalysisshopApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    ItemsService itemsService;

    @Test
    public void contextLoads() {
        System.out.println("asdasdasda");
    }

    @Test
    public void getrecommded() {
        List<Items> items= itemsService.getRecommend("1");
        items.forEach(e->{
            System.out.println(e.getId()+" "+e.getName());
        });
        System.out.println();
    }

}
