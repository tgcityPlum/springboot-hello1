package com.tgcity.example.demo1.controller.mobile.system;

import com.alibaba.fastjson.JSON;
import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import com.tgcity.example.demo1.common.model.response.system.LoginUserResponse;
import com.tgcity.example.demo1.common.utils.HttpClientUtils;
import com.tgcity.example.demo1.common.utils.ShiroUtils;
import com.tgcity.example.demo1.dal.entity.user.QQUserInfo;
import com.tgcity.example.demo1.service.system.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author: TGCity
 * @create: 2020/5/27
 * @description 登录模块的controller
 */
@RestController
@RequestMapping("/mobile/system/start")
@Api(tags = "3、登录模块")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Value("${system.social.qq.app-id}")
    public String appId;

    /**
     * 1、用户登录
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登录", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "account", value = "账号", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", required = true)
    })
    public BaseResponse<LoginUserResponse> login(String account, String password) {
        return accountService.login(account, password);
    }


    /**
     * 2、注册用户
     */
    @PostMapping("register")
    @ApiOperation(value = "注册用户", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "registerReq", value = "注册表单", required = true, dataType = "RegisterReq")
    public BaseResponse register(@Valid @RequestBody RegisterReq registerReq) {
        return accountService.register(registerReq);
    }

    /**
     * 3、退出登录
     */
    @GetMapping("logout")
    @ApiOperation(value = "用户退出登录", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse logout() {
        ShiroUtils.logout();
        return BaseResponse.ok().build();
    }

    /**
     * 4 用户是否登录失效
     */
    @GetMapping("isValid")
    @ApiOperation(value = "用户是否登录失效", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<Boolean> isValid(HttpServletRequest request, HttpServletResponse response) {
        try {
            SessionKey key = new WebSessionKey(request, response);
            Session session = SecurityUtils.getSecurityManager().getSession(key);
            Object attribute = session.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
            if (attribute == null) {
                return BaseResponse.buildSuccess(Message.NOT_LOGGED_IN).build();
            } else {
                return BaseResponse.ok(true);
            }
        } catch (Exception e) {
            return BaseResponse.buildSuccess(Message.NOT_LOGGED_IN).build();
        }
    }

    /**
     * 5 QQ登录
     */
    @GetMapping("login/qq")
    @ApiOperation(value = "QQ登录", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<LoginUserResponse> qqLogin(String accessToken, String openId) {
        //获取QQUserInfo
        QQUserInfo userInfo = accountService.getQQUserInfo(accessToken, openId);
        if (userInfo == null) {
            return BaseResponse.buildSuccess(Message.QQ_LOGIN_ERROR).build();
        }else {
            //校验openId是否绑定

        }


            LoginUserResponse loginUserResponse = LoginUserResponse.of();
//            loginUserResponse.setAccount();
            loginUserResponse.setAvatar(userInfo.getFigureurl_qq());
            loginUserResponse.setNickName(userInfo.getNickname());


        return BaseResponse.ok(null);
    }


}
