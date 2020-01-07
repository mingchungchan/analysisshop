package com.example.analysisshop.controller;

import com.example.analysisshop.entity.User;
import com.example.analysisshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * R.put("click", 1);// 点击
 * R.put("collect", 2); // 收藏
 * R.put("cart", 3); // 添加购物车
 * R.put("alipay", 4); // 支付
 */
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "I am Here";
    }

    @ResponseBody
    @RequestMapping("/getAllUser")
    private List<User> getAllUser() {
        List<User> users =  userService.getAllUser();
        return users;
    }

    @RequestMapping("/register")
    private String gotoRegister() {
        return "register";
    }

    @RequestMapping("/userLogin")
    private String gotoUserLogin() {
        return "userLogin";
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @RequestMapping(value = {"/loginMethon"})
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){

        User user = userService.userlogin(username,password);

        if(user != null){                                                  //登录成功
            request.getSession().setAttribute("session_user",user);     //将用户信息放入session
            return "index";
        }
        return "loginError";
    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2){

        if(!password.equals(password2)){

            return "两次密码不相同，注册失败！！";
        }else {
            int res = userService.adduser(username,password);
            if(res == 0){
                return "注册失败！";
            }else {
                return "注册成功！";
            }
        }

    }

}
