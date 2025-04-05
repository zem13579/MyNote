package com.zem.designpattern.book.bridge.function;

import com.zem.designpattern.book.bridge.abst.AbstractRegisterLoginFunc;
import com.zem.designpattern.book.bridge.abst.factory.RegisterLoginComponentFactory;
import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.repo.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author zem
 * @Date 2023/11/7
 * @Describe
 */
@Component
public class RegisterLoginByDedault extends AbstractRegisterLoginFunc implements RegisterLoginFuncInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String account, String password) {
       return super.commonLogin(account,password,userRepository);
    }

    @Override
    public String register(UserInfo userInfo) {
       return super.commonRegister(userInfo,userRepository);
    }

    @Override
    public boolean checkUserExists(String userName) {
        return super.commonCheckUserExists(userName,userRepository);
    }

    @PostConstruct
    private void initFuncMap(){
        RegisterLoginComponentFactory.funcInterfaceMap.put("Default",this);
    }

}
