package com.zem.designpattern.book.adapter;

import com.alibaba.fastjson.JSONObject;
import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.service.UserService;
import com.zem.designpattern.book.utils.HttpClientUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @Author zem
 * @Date 2023/11/1
 * @Describe
 */
@Component
@Log
public class Login3rdAdapter extends UserService implements Login3rdTarget{


    @Value("${gitee.state}")
    private String giteeState;

    @Value("${gitee.token.url}")
    private String giteeTokenUrl;

    @Value("${gitee.user.url}")
    private String getGiteeUserUrl;

    @Value("${gitee.user.prefix}")
    private String giteeUserPrefix;

    @Override
    public String loginByGitee(String code, String state) {
        if(!giteeState.equals(state)){
            throw new UnsupportedOperationException("invalid state!");
        }
        String tokenUrl = giteeTokenUrl.concat(code);
        JSONObject tokenResponse = HttpClientUtils.execute(tokenUrl, HttpMethod.POST);
        String accessToken = String.valueOf(tokenResponse.get("access_token"));

        String userUrl = getGiteeUserUrl.concat(accessToken);
        JSONObject userInfo = HttpClientUtils.execute(userUrl, HttpMethod.GET);
        String name = giteeUserPrefix.concat(String.valueOf(userInfo.get("name")));
        return autoRegister3rdAndLogIn(name,name);
    }


    private String autoRegister3rdAndLogIn(String userName,String password){
        if(super.checkUserExists(userName)){
            return login(userName,password);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserPassword(password);
        userInfo.setCreateDate(new Date());
        super.register(userInfo);
        return super.login(userName,password);
    }

    @Override
    public String loginByWeChat(String code, String state) {
        return null;
    }

    @PostConstruct
    public void initMethod(){
        log.info("===初始化信息====");
        log.info("giteeState:"+giteeState);
        log.info("giteeTokenUrl:"+giteeTokenUrl);
        log.info("getGiteeUserUrl:"+getGiteeUserUrl);
        log.info("giteeUserPrefix:"+giteeUserPrefix);
    }
}
