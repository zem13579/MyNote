package com.zem.designpattern.book.bridge.function;

import com.zem.designpattern.book.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;

public interface RegisterLoginFuncInterface {
     String login(String account,String password);
     String register(UserInfo userInfo);
     boolean checkUserExists(String userName);
     String login3rd(HttpServletRequest request);
}
