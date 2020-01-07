package com.example.analysisshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shop")
public class ItemController {


    @ResponseBody
    @RequestMapping("/item")
    public String getItem(int itemid,String action){
        return itemid + action;
    }
}
