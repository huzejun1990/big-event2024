package com.dream.controller;

import com.dream.pojo.Result;
import com.dream.pojo.User;
import com.dream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: huzejun
 * @Date: 2024/9/30 14:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //没有占用
            //注册
            userService.register(username,password);
            return Result.success();
        }else {
            //占用
            return Result.error("用户名已被占用");
        }
    }
}
