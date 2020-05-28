package com.tgcity.example.demo1.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import com.tgcity.example.demo1.dal.mappers.system.AccountMapper;
import com.tgcity.example.demo1.service.system.AccountService;
import com.tgcity.example.demo1.utils.ShiroUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 账户信息向外部提供的实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 注册的逻辑处理
     *
     * @param registerReq RegisterReq RegisterReq
     * @return Long
     */
    @Override
    public BaseResponse register(RegisterReq registerReq) {
        //校验账号信息
        if (StringUtils.isBlank(registerReq.getAccount())){
            return BaseResponse.buildSuccess(Message.USER_ACCOUNT_NOT_EMPTY).build();
        }
        Integer accountCount = accountMapper.selectCount(new QueryWrapper<AccountEntity>().eq("user_account", registerReq.getAccount()));
        if (accountCount > 0) {
            return BaseResponse.buildSuccess(Message.ACCOUNT_EXIST).build();
        }
        //校验密码
        if (StringUtils.isBlank(registerReq.getPassword())){
            return BaseResponse.buildSuccess(Message.USER_PASSWORD_NOT_EMPTY).build();
        }
        AccountEntity accountEntity = AccountEntity.of();
        //userId
        String userId;

        while (true) {
            userId = RandomStringUtils.random(15,"abcde1234567890");
            Integer userIdCount = accountMapper.selectCount(new QueryWrapper<AccountEntity>().eq("user_id", userId));
            if (userIdCount == 0) {
                break;
            }
        }
        //加密密码
        String salt = RandomStringUtils.randomAlphanumeric(20);
        //平台
        String systemType;
        switch (registerReq.getSystem()) {
            case 1:
                systemType = "安卓端";
                break;
            case 2:
                systemType = "苹果端";
                break;
            case 3:
                systemType = "前端";
                break;
            case 4:
                systemType = "后端";
                break;
            case 5:
                systemType = "数据库";
                break;
            default:
                systemType = "其它";
                break;
        }
        accountEntity
                .setUserId(userId)
                .setAccount(registerReq.getAccount())
                .setPassword(registerReq.getPassword())
                .setPasswordEncryption(ShiroUtils.sha256(registerReq.getPassword(), salt))
                .setPlatform(systemType);
        //处理平台
        accountMapper.insert(accountEntity);
        return BaseResponse.ok().build();
    }
}
