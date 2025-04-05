package com.zem.designpattern.book.controller;

import com.zem.designpattern.book.adapter.Login3rdAdapter;
import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zem
 * @Date 2023/10/30
 * @Describe
 */
@RestController
@Log
public class UserController {

    @Autowired
    private Login3rdAdapter login3rdAdapter;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(String account, String password) {
        return userService.login(account, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }

    @GetMapping("/gitee")
    public String gitee(String code,String state){
        return login3rdAdapter.loginByGitee(code,state);
    }


}
