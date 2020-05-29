package com.tgcity.example.demo1.common.model.request.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 注册的请求体
 */
@Data
@ApiModel(description = "注册表单")
public class RegisterReq {

    @ApiModelProperty(name = "account", value = "用户账号", required = true, example = "admin")
    @NotBlank(message = "账号不能为空")
    private String account;

    @ApiModelProperty(name = "password", value = "用户密码", required = true, example = "admin123")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(name = "system", value = "注册平台：1 安卓端  2 苹果端  3 前端  4 后端  5 数据库  6 其它")
    private int system;

}
