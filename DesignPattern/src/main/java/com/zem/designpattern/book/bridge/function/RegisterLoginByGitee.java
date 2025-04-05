package com.zem.designpattern.book.bridge.function;

import com.alibaba.fastjson.JSONObject;
import com.zem.designpattern.book.bridge.abst.AbstractRegisterLoginFunc;
import com.zem.designpattern.book.bridge.abst.factory.RegisterLoginComponentFactory;
import com.zem.designpattern.book.pojo.UserInfo;
import com.zem.designpattern.book.repo.UserRepository;
import com.zem.designpattern.book.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
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
public class RegisterLoginByGitee extends AbstractRegisterLoginFunc implements RegisterLoginFuncInterface {

    @Value("${gitee.state}")
    private String giteeState;

    @Value("${gitee.token.url}")
    private String giteeTokenUrl;

    @Value("${gitee.user.url}")
    private String getGiteeUserUrl;

    @Value("${gitee.user.prefix}")
    private String giteeUserPrefix;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login3rd(HttpServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        if (!giteeState.equals(state)) {
            throw new UnsupportedOperationException("Invalid state！");
        }
        String tokenUrl = giteeTokenUrl.concat(code);
        JSONObject tokenResponse = HttpClientUtils.execute(tokenUrl, HttpMethod.POST);
        String accessToken = String.valueOf(tokenResponse.get("access_token"));

        String userUrl = getGiteeUserUrl.concat(accessToken);
        JSONObject userInfo = HttpClientUtils.execute(userUrl, HttpMethod.GET);
        String name = giteeUserPrefix.concat(String.valueOf(userInfo.get("name")));
        return autoRegister3rdAndLogIn(name, name);
    }

    private String autoRegister3rdAndLogIn(String userName, String password) {
        if (super.commonCheckUserExists(userName, userRepository)) {
            return super.commonLogin(userName, password, userRepository);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserPassword(password);
        userInfo.setCreateDate(new Date());
        super.commonRegister(userInfo, userRepository);
        return super.commonLogin(userName, password, userRepository);
    }

    @PostConstruct
    private void initFuncMap() {
        RegisterLoginComponentFactory.funcInterfaceMap.put("GITEE", this);
    }
}
