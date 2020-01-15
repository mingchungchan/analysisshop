package com.example.analysisshop.controller;

import com.example.analysisshop.common.AssertUtil;
import com.example.analysisshop.common.Result;
import com.example.analysisshop.common.ResultUtils;
import com.example.analysisshop.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shop")
public class ItemController {

    @Resource
    ItemsService itemsService;


    @ResponseBody
    @RequestMapping("/item")
    public String getItem(int itemid,String action){
        return itemid + action;
    }


    @ResponseBody
    @RequestMapping("/getAll")
    public Result getAll() {
        return ResultUtils.succeed(itemsService.getAll());
    }


    @ResponseBody
    @RequestMapping("/getMe")
    public Result getMe(Integer i) {
        System.out.println(i);
        AssertUtil.validIsNull(i);
        return ResultUtils.succeed();
    }

    @ResponseBody
    @RequestMapping("/testRedis")
    public Result testRedis(HttpServletRequest request) {
        request.getSession().setAttribute("ni","meiyou");
        return ResultUtils.succeed();
    }
}
