package com.tgcity.example.demo1.common.shiro.web;

import com.tgcity.example.demo1.common.model.response.system.UserInfoResponse;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.springframework.beans.BeanUtils;

/**
 * @author Administrator
 * @create 2019/7/24 0024 15:54
 */
public class WebContentUtil {

    public static UserInfoResponse getAccountInfo() {
        UserInfoResponse userInfoResponse = UserInfoResponse.of();
        AccountEntity user;
        try {
            user = (AccountEntity) SecurityUtils.getSubject().getPrincipal();
        } catch (UnavailableSecurityManagerException e) {
            userInfoResponse.setAccount("system");
            return userInfoResponse;
        }
        if (user != null) {
            BeanUtils.copyProperties(user, userInfoResponse);
        } else {
            userInfoResponse.setAccount("匿名");
        }
        return userInfoResponse;
    }

}
