package com.zem.designpattern.book.bridge.abst;

import com.zem.designpattern.book.bridge.function.RegisterLoginFuncInterface;
import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.repo.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author zem
 * @Date 2023/11/8
 * @Describe
 */
public abstract class AbstractRegisterLoginFunc implements RegisterLoginFuncInterface {


    protected String commonLogin(String account, String password, UserRepository userRepository){
        UserInfo userInfo = userRepository.findUserInfoByUserNameAndUserPassword(account, password);
        if (userInfo == null) {
            return "login fail";
        }
        return "login success";
    }

    protected String commonRegister(UserInfo userInfo,UserRepository userRepository){
        if (commonCheckUserExists(userInfo.getUserName(),userRepository)) {
            return "user already registed";
        }
        userInfo.setCreateDate(new Date());
        userRepository.save(userInfo);
        return "register success";
    }

    protected boolean commonCheckUserExists(String userName,UserRepository userRepository) {
       return userRepository.findUserInfoByUserName(userName) != null;
    }

    @Override
    public String login(String account, String password){
        throw new UnsupportedOperationException();
    }
    @Override
    public String register(UserInfo userInfo){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkUserExists(String userName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String login3rd(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }


}
