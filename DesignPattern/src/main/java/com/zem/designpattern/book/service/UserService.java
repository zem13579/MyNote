package com.zem.designpattern.book.service;

import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author zem
 * @Date 2023/10/30
 * @Describe
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String login(String account, String password) {
        UserInfo userInfo = userRepository.findUserInfoByUserNameAndUserPassword(account, password);
        if (userInfo == null) {
            return "account/passwrod error!";
        }
        return "login success";
    }

    public String register(UserInfo userInfo) {
        if (checkUserExists(userInfo.getUserName())) {
            throw new RuntimeException("account already registered");
        }
        userInfo.setCreateDate(new Date());
        userRepository.save(userInfo);
        return "register success";
    }

    public boolean checkUserExists(String userName) {
        UserInfo userInfoByUserName = userRepository.findUserInfoByUserName(userName);
        return userInfoByUserName != null;
    }
}
