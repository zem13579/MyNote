package com.zem.designpattern.book.bridge.abst;

import com.zem.designpattern.book.bridge.function.RegisterLoginFuncInterface;
import com.zem.designpattern.book.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zem
 * @Date 2023/11/7
 * @Describe
 */
public abstract class AbstractRegisterLoginComponent {
    protected RegisterLoginFuncInterface funcInterface;

    public AbstractRegisterLoginComponent(RegisterLoginFuncInterface funcInterface) {
        validate(funcInterface);
        this.funcInterface = funcInterface;
    }

    private void validate(RegisterLoginFuncInterface registerLoginFuncInterface) {
        if (registerLoginFuncInterface == null) {
            throw new NullPointerException("interface must not be null");
        }
    }

    public abstract String login(String account, String password);

    public abstract String register(UserInfo userInfo);

    protected abstract boolean checkUserExists(String userName);

    public abstract String login3rd(HttpServletRequest request);
}
