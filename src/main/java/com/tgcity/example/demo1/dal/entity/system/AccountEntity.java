package com.tgcity.example.demo1.dal.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tgcity.example.demo1.dal.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 账户实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@TableName("w_account")
@ApiModel(description = "账户实体类")
public class AccountEntity extends BaseEntity {

    private static final long serialVersionUID = 2L;

    @ApiModelProperty(name = "user_account", value = "用户账号名称")
    @TableField(value = "user_account")
    private String account;

    @ApiModelProperty(name = "user_id", value = "用户id")
    @TableField(value = "user_id")
    private String userId;

    @ApiModelProperty(name = "password", value = "用户密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(name = "password_encryption", value = "用户密码加密")
    @TableField(value = "password_encryption")
    private String passwordEncryption;

    @ApiModelProperty(name = "nick_name", value = "用户昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty(name = "phone", value = "用户手机号")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(name = "avatar", value = "用户头像")
    @TableField(value = "avatar")
    private String avatar;

    @ApiModelProperty(name = "platform", value = "用户平台途径")
    @TableField(value = "platform")
    private String platform;

}
