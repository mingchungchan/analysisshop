package com.example.analysisshop.controller;

import com.example.analysisshop.common.Result;
import com.example.analysisshop.common.ResultUtils;
import com.example.analysisshop.dto.ItemsCreateDto;
import com.example.analysisshop.dto.ItemsDto;
import com.example.analysisshop.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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


    /**
     * 后台分页查找
     */
    @ResponseBody
    @RequestMapping("/findByPage")
    public Result findByPage(ItemsDto dto) {
        return ResultUtils.succeed(itemsService.findByPage(dto));
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/save")
    public Result save(@Validated ItemsCreateDto dto) {
        return ResultUtils.succeed(itemsService.save(dto));
    }

}
