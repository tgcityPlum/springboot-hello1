package com.tgcity.example.demo1.controller.mobile.system;

import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import com.tgcity.example.demo1.common.model.response.system.LoginUserResponse;
import com.tgcity.example.demo1.common.utils.ShiroUtils;
import com.tgcity.example.demo1.service.system.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
        //校验账号信息
        if (StringUtils.isBlank(account)) {
            return BaseResponse.buildSuccess(Message.USER_ACCOUNT_NOT_EMPTY).build();
        }
        //校验密码
        if (StringUtils.isBlank(password)) {
            return BaseResponse.buildSuccess(Message.USER_PASSWORD_NOT_EMPTY).build();
        }
        return accountService.login(account, password);
    }


    /**
     * 2、注册用户
     */
    @PostMapping("register")
    @ApiOperation(value = "注册用户", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "registerReq", value = "注册表单", required = true, dataType = "RegisterReq")
    public BaseResponse register(@Valid @RequestBody RegisterReq registerReq) {
        //校验账号信息
        if (StringUtils.isBlank(registerReq.getAccount())) {
            return BaseResponse.buildSuccess(Message.USER_ACCOUNT_NOT_EMPTY).build();
        }
        //校验密码
        if (StringUtils.isBlank(registerReq.getPassword())) {
            return BaseResponse.buildSuccess(Message.USER_PASSWORD_NOT_EMPTY).build();
        }
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

}
