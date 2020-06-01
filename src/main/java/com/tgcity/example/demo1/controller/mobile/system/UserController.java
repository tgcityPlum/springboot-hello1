package com.tgcity.example.demo1.controller.mobile.system;

import com.tgcity.example.demo1.common.model.request.system.ResetPasswordReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import com.tgcity.example.demo1.common.model.response.system.UserInfoResponse;
import com.tgcity.example.demo1.service.system.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    @PutMapping("update/password")
    @ApiOperation(value = "修改用户密码", httpMethod = "PUT", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "request", value = "请求体", required = true, dataType = "ResetPasswordReq")
    public BaseResponse updatePassword(@Valid @RequestBody ResetPasswordReq request) {
        //校验信息
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            return BaseResponse.buildSuccess(Message.TWO_PASSWORD_EQUAL).build();
        }
        return accountService.resetPassword(request);
    }

    /**
     * 3、找回用户密码
     */

    /**
     * 4、修改用户信息
     */
    @PutMapping("update/info")
    @ApiOperation(value = "修改用户信息", httpMethod = "PUT", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "request", value = "请求体", dataType = "UserInfoResponse", required = true)
    public BaseResponse updateInfo(@RequestBody UserInfoResponse request) {
        return accountService.resetInfo(request);
    }

    /**
     * 5 更新头像
     */
    @PutMapping("update/avatar")
    @ApiOperation(value = "更新头像", httpMethod = "PUT", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "avatar", value = "base64头像路径", dataType = "String", required = true)
    public BaseResponse updateAvatar(@RequestBody String avatar) {
        return accountService.updateAvatar(avatar);
    }
}
