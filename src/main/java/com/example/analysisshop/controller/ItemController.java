package com.example.analysisshop.controller;

import com.example.analysisshop.common.Result;
import com.example.analysisshop.common.ResultUtils;
import com.example.analysisshop.dto.ItemsCreateDto;
import com.example.analysisshop.dto.ItemsDto;
import com.example.analysisshop.entity.Items;
import com.example.analysisshop.entity.User;
import com.example.analysisshop.service.ItemsService;
import com.example.analysisshop.vo.ItemsVo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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


    /**
     * 获取全部商品
     */
    @ResponseBody
    @RequestMapping("/getAll")
    public Result getAll(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            user = new User();
            user.setId(0);
        }

        List<Items> items = itemsService.getAll();
        return transformResult(user, items);
    }

    /**
     * 获取推荐列表
     */
    @ResponseBody
    @RequestMapping("/getRecommend")
    public Result getRecommend(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultUtils.succeed();
        }

        List<Items> items = itemsService.getRecommend(user.getId().toString());
        return transformResult(user, items);
    }



    private Result transformResult(User user, List<Items> items) {
        List<ItemsVo> itemsVos = new ArrayList<>();
        User finalUser = user;
        items.forEach(e->{
            ItemsVo itemsVo = new ItemsVo();
            itemsVo.initFromDo(e);
            itemsVo.setUid(finalUser.getId());
            itemsVos.add(itemsVo);
        });
        return ResultUtils.succeed(itemsVos);
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
