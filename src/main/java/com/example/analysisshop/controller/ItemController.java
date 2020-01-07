package com.example.analysisshop.controller;

import com.example.analysisshop.common.AssertUtil;
import com.example.analysisshop.common.Enum.CommonError;
import com.example.analysisshop.common.Result;
import com.example.analysisshop.common.ResultUtils;
import com.example.analysisshop.common.exception.ServiceException;
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


    @ResponseBody
    @RequestMapping("/getMe")
    public Result getMe(Integer i) {
        System.out.println(i);
        AssertUtil.validIsNull(i);
        return ResultUtils.succeed();
    }
}
