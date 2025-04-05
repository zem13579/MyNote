package com.zem.designpattern.book.bridge.abst;

import com.zem.designpattern.book.bridge.function.RegisterLoginFuncInterface;
import com.zem.designpattern.book.pojo.UserInfo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zem
 * @Date 2023/11/7
 * @Describe
 */
public class RegisterLoginComponent extends AbstractRegisterLoginComponent{


    public RegisterLoginComponent(RegisterLoginFuncInterface funcInterface) {
        super(funcInterface);
    }

    @Override
    public String login(String account, String password) {
        return funcInterface.login(account,password);
    }

    @Override
    public String register(UserInfo userInfo) {
        return funcInterface.register(userInfo);
    }

    @Override
    protected boolean checkUserExists(String userName) {
        return funcInterface.checkUserExists(userName);
    }

    @Override
    public String login3rd(HttpServletRequest request) {
        return funcInterface.login3rd(request);
    }
}
