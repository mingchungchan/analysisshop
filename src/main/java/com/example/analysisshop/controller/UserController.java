package com.example.analysisshop.controller;

import com.example.analysisshop.common.AssertUtil;
import com.example.analysisshop.common.Result;
import com.example.analysisshop.common.ResultUtils;
import com.example.analysisshop.entity.User;
import com.example.analysisshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * R.put("click", 1);// 点击
 * R.put("collect", 2); // 收藏
 * R.put("cart", 3); // 添加购物车
 * R.put("alipay", 4); // 支付
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/getAllUser")
    private List<User> getAllUser() {
        List<User> users =  userService.getAllUser();
        return users;
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @ResponseBody
    @RequestMapping(value = {"/login"})
    public Result userLogin(@Validated User user, HttpServletRequest request){
        User loguser = userService.userlogin(user.getUsername(),user.getPassword());

        if(loguser != null){                                          //登录成功
            request.getSession().setAttribute("user",loguser);     //将用户信息放入session
            return ResultUtils.succeed();
        }
        return ResultUtils.failed();
    }

    /**
     * 获取当前登录用户
     */
    @ResponseBody
    @RequestMapping(value = {"/getUser"})
    public Result getUser(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return ResultUtils.succeed(user);
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @RequestMapping(value = {"/login2"})
    public Result userLogin2(@Validated @RequestBody User user, HttpServletRequest request){
        return ResultUtils.succeed();
    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/register"})
    public Result addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2){

        if(!password.equals(password2)){
            return ResultUtils.failed("1001","两次密码不相同，注册失败！！");
        }else {
            int res = userService.adduser(username,password);
            System.out.println(res);
        }
        return ResultUtils.succeed();
    }

    @ResponseBody
    @RequestMapping(value = {"/getAll"})
    public String findAllUser() {
        System.out.println("sssss");
        userService.search().forEach(System.out::println);
        return "ok";
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
        request.getSession().setAttribute("niwww",11);

        User user = new User();
        user.setUsername("sss");
        user.setId(123);
        user.setAge(12);
        request.getSession().setAttribute("uua",user);

        User user1 = (User) request.getSession().getAttribute("uua");
        System.out.println(user1.getUsername()+user1.getId()+"  "+user1.getAge());
        return ResultUtils.succeed();
    }

    @ResponseBody
    @RequestMapping("/testRedis2")
    public Result testRedis2(HttpServletRequest request) {
        User user1 = (User) request.getSession().getAttribute("uua");
        System.out.println(user1.getUsername()+user1.getId()+"  "+user1.getAge());


        User ser = (User) request.getSession().getAttribute("user");
        System.out.println(ser.getUsername()+ser.getId()+"  "+ser.getAge());
        return ResultUtils.succeed();
    }

}
