package com.tgcity.example.demo1.common.model;

import com.tgcity.example.demo1.dal.entity.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 账户信息
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
public class AccountVo extends BaseEntity {

    private String account;

    private String userId;

    private String password;

    private String passwordEncryption;

    private String nickName;

    private String phone;

    private String avatar;

}
