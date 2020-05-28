package com.tgcity.example.demo1.controller.mobile.system;

import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.service.system.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: TGCity
 * @create: 2020/5/27
 * @description 登录模块的controller
 */
@RestController
@RequestMapping("/mobile/system/login")
@Api(tags = "3、登录模块")
public class LoginController {

    @Autowired
    private AccountService accountService;

    /**
     * 1、用户登录
     */


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
}
