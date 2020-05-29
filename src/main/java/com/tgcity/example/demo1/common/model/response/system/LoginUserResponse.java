package com.tgcity.example.demo1.common.model.response.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 登录返回实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@ApiModel(description = "登录实体类")
public class LoginUserResponse {

    @ApiModelProperty(name = "user_account", value = "用户账号名称")
    private String account;

    @ApiModelProperty(name = "user_id", value = "用户id")
    private String userId;

    @ApiModelProperty(name = "nick_name", value = "用户昵称")
    private String nickName;

    @ApiModelProperty(name = "phone", value = "用户手机号")
    private String phone;

    @ApiModelProperty(name = "avatar", value = "用户头像")
    private String avatar;

}
