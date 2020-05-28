package com.tgcity.example.demo1.common.shiro.web;

import com.tgcity.example.demo1.common.model.AccountVo;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.springframework.beans.BeanUtils;

/**
 * @author Administrator
 * @create 2019/7/24 0024 15:54
 */
public class WebContentUtil {

    public static AccountVo getAccountInfo() {
        AccountVo accountVo = AccountVo.of();
        AccountEntity user;
        try {
            user = (AccountEntity) SecurityUtils.getSubject().getPrincipal();
        } catch (UnavailableSecurityManagerException e) {
            accountVo.setAccount("system");
            return accountVo;
        }
        if (user != null) {
            BeanUtils.copyProperties(user, accountVo);
        } else {
            accountVo.setAccount("匿名");
        }
        return accountVo;
    }

}
