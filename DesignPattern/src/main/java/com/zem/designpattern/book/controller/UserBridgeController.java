package com.zem.designpattern.book.controller;

import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.service.UserBridgeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zem
 * @Date 2023/10/30
 * @Describe
 */
@RestController
@Log
@RequestMapping("/bridge")
public class UserBridgeController {


    @Autowired
    private UserBridgeService userBridgeService;

    @PostMapping("/login")
    public String login(String account, String password) {
        return userBridgeService.login(account, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserInfo userInfo) {
        return userBridgeService.register(userInfo);
    }

    @GetMapping("/gitee")
    public String gitee(HttpServletRequest request){
        return userBridgeService.login3rd(request,"GITEE");
    }


}
