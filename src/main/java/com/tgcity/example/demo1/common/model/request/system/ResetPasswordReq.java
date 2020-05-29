package com.tgcity.example.demo1.common.model.request.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: TGCity
 * @create: 2020/5/29
 * @description 修改密码的请求体
 */
@Data
@ApiModel(description = "请求体")
public class ResetPasswordReq {

    @ApiModelProperty(name = "oldPassword", value = "原密码", required = true)
    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    @ApiModelProperty(name = "newPassword", value = "新密码", required = true)
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    @ApiModelProperty(name = "confirmPassword", value = "确认密码", required = true)
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}
