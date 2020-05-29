package com.tgcity.example.demo1.controller.mobile.system;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.system.UserInfoResponse;
import com.tgcity.example.demo1.service.system.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: TGCity
 * @create: 2020/5/27
 * @description 用户的Controller
 */
@RestController
@RequestMapping("/mobile/system/user")
@Api(tags = "4、用户模块")
public class UserController {

    @Autowired
    private AccountService accountService;

    /**
     * 1、获取用户信息
     */
    @GetMapping("info")
    @ApiOperation(value = "获取用户信息", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<UserInfoResponse> getInfo() {
        return accountService.userInfo();
    }

    /**
     * 2、修改用户密码
     */

    /**
     * 3、找回用户密码
     */

    /**
     * 4、修改用户信息
     */

}
