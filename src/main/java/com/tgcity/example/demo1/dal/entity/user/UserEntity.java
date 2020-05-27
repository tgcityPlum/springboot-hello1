package com.tgcity.example.demo1.dal.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/5/26
 * @description  用户实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@TableName("user")
@ApiModel(description = "用户账户类")
public class UserEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id",value = "id",example = "0")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "name",value = "用户账号名称",example = "test")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(name = "password",value = "用户密码",example = "test123456")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(name = "nickName",value = "用户昵称",example = "测试账号")
    @TableField(value = "nickname")
    private String nickName;

}
