/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tgcity.example.demo1.common.shiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import com.tgcity.example.demo1.dal.mappers.system.AccountMapper;
import com.tgcity.example.demo1.common.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 认证
 */
@Component
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
//    @Autowired
//    private AuthService authService;

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("------PC------shiro授权---------------");
        /*AccountEntity accountEntity = (AccountEntity) principals.getPrimaryPrincipal();
        if (accountEntity == null) {
            return null;
        }
        //用户权限列表
        Set<String> permsSet = authService.selectAuthResourceCode(accountEntity.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;*/

        //在这里进行一些授权 分发权限等等
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        //接受AuthenticationInfo传递过来的User对象
        AccountEntity user = (AccountEntity) subject.getPrincipal();
        /* System.out.println(user.getShiro());*/
        //设置权限
        info.addStringPermission("user:root");
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        log.debug("-------PC-----shiro认证---------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        //查询用户信息
        AccountEntity account = accountMapper.selectOne(new QueryWrapper<AccountEntity>().eq("user_account", token.getUsername()));
        //账号不存在
        if (account == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        return new SimpleAuthenticationInfo(account, account.getPassword(), ByteSource.Util.bytes(account.getPasswordEncryption()), getName());
    }

    /**
     * 凭证匹配器
     *
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
