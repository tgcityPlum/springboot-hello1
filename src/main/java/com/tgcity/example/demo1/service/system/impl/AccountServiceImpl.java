package com.tgcity.example.demo1.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.request.system.ResetPasswordReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import com.tgcity.example.demo1.common.model.response.system.LoginUserResponse;
import com.tgcity.example.demo1.common.model.response.system.UserInfoResponse;
import com.tgcity.example.demo1.common.utils.ShiroUtils;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import com.tgcity.example.demo1.dal.mappers.system.AccountMapper;
import com.tgcity.example.demo1.service.system.AccountService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
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
        Integer accountCount = accountMapper.selectCount(new QueryWrapper<AccountEntity>().eq("user_account", registerReq.getAccount()));
        if (accountCount > 0) {
            return BaseResponse.buildSuccess(Message.ACCOUNT_EXIST).build();
        }

        AccountEntity accountEntity = AccountEntity.of();
        //userId
        String userId;

        while (true) {
            userId = RandomStringUtils.random(15, "abcde1234567890");
            Integer userIdCount = accountMapper.selectCount(new QueryWrapper<AccountEntity>().eq("user_id", userId));
            if (userIdCount == 0) {
                break;
            }
        }
        //加密密码
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String password = ShiroUtils.sha256(registerReq.getPassword(), salt);
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
                .setPassword(password)
                .setPasswordEncryption(salt)
                .setPlatform(systemType);
        //处理平台
        accountMapper.insert(accountEntity);
        return BaseResponse.ok().build();
    }

    @Override
    public BaseResponse<LoginUserResponse> login(String account, String password) {
        //登录（shiro）
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            subject.login(token);

            AccountEntity user = (AccountEntity) SecurityUtils.getSubject().getPrincipal();
            LoginUserResponse loginUserResponse = LoginUserResponse.of();
            BeanUtils.copyProperties(user, loginUserResponse);

            return BaseResponse.ok(loginUserResponse);
        } catch (UnknownAccountException e) {
            return BaseResponse.code(403).msg(e.getMessage()).build();
        } catch (IncorrectCredentialsException e) {
            return BaseResponse.buildSuccess(Message.INVALID_USERNAME_OR_PASSWORD).build();
        } catch (LockedAccountException e) {
            return BaseResponse.code(400).msg("账号已被锁定,请联系管理员").build();
        } catch (AuthenticationException e) {
            return BaseResponse.buildSuccess(Message.ACCOUNT_VERIFICATION_FAILED).build();
        } catch (Exception e) {
            return BaseResponse.code(400).msg("网络异常,请联系管理员").build();
        }
    }

    @Override
    public BaseResponse<UserInfoResponse> userInfo() {
        AccountEntity user = (AccountEntity) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            return BaseResponse.buildSuccess(Message.NOT_LOGGED_IN).build();
        }
        UserInfoResponse userInfoResponse = UserInfoResponse.of();
        BeanUtils.copyProperties(user, userInfoResponse);
        return BaseResponse.ok(userInfoResponse);
    }

    @Override
    public BaseResponse resetPassword(ResetPasswordReq request) {
        //校验用户是否在线
        AccountEntity user = (AccountEntity) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            return BaseResponse.buildSuccess(Message.NOT_LOGGED_IN).build();
        }
        //校验老密码是否一致
        String password = ShiroUtils.sha256(request.getOldPassword(), user.getPasswordEncryption());
        if (!user.getPassword().equals(password)) {
            return BaseResponse.buildSuccess(Message.PASSWORD_ERROR).build();
        }
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPasswordEncryption(salt);
        user.setPassword(ShiroUtils.sha256(request.getNewPassword(), salt));
        int updateCount = accountMapper.updateById(user);
        if (updateCount != 1) {
            return BaseResponse.buildSuccess(Message.UPDATE_FAIL).build();
        }
        return BaseResponse.ok().build();
    }
}
