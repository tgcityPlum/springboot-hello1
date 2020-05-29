/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tgcity.example.demo1.common.shiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tgcity.example.demo1.common.shiro.WechatToken;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import com.tgcity.example.demo1.dal.mappers.system.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 微信的认证
 */
@Component
@Slf4j
public class WechatShiroRealm extends AuthorizingRealm {
    //    @Autowired
//    private AuthService authService;
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("-------wechat-----shiro授权---------------");
       /* AccountEntity accountEntity = (AccountEntity) principals.getPrimaryPrincipal();
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
        log.debug("------wechat------shiro认证---------------");
        WechatToken token = (WechatToken) authcToken;
        String openId = token.getOpenId();
        //查询用户信息
        AccountEntity account = accountMapper.selectOne(new QueryWrapper<AccountEntity>().eq("open_id", openId));
        //账号不存在
        if (account == null) {
            throw new UnknownAccountException("账号不存在");
        }
        return new SimpleAuthenticationInfo(account, "ok", this.getClass().getSimpleName());
    }


}
