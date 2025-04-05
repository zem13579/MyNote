package com.zem.designpattern.book.service;

import com.zem.designpattern.book.bridge.abst.AbstractRegisterLoginComponent;
import com.zem.designpattern.book.bridge.abst.RegisterLoginComponent;
import com.zem.designpattern.book.bridge.abst.factory.RegisterLoginComponentFactory;
import com.zem.designpattern.book.bridge.function.RegisterLoginByDedault;
import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author zem
 * @Date 2023/10/30
 * @Describe
 */
@Service
public class UserBridgeService {

    @Autowired
    private UserRepository userRepository;

    public String login(String account, String password) {
        AbstractRegisterLoginComponent component = RegisterLoginComponentFactory.getCompoentMap("Default");
        return component.login(account, password);
    }

    public String register(UserInfo userInfo) {
        AbstractRegisterLoginComponent component = RegisterLoginComponentFactory.getCompoentMap("Default");
        return component.register(userInfo);
    }

    public String login3rd(HttpServletRequest request, String type) {
        AbstractRegisterLoginComponent component = RegisterLoginComponentFactory.getCompoentMap(type);
        return component.login3rd(request);
    }
}
