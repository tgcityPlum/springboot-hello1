package com.tgcity.example.demo1.service.system;

import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 账户信息向外部提供的接口
 */
public interface AccountService {

    /**
     * 1 注册用户
     * @param registerReq RegisterReq
     * @return BaseResponse
     */
    BaseResponse register(RegisterReq registerReq);

    /**
     * 2 用户登录
     * @param account 账号
     * @param password 密码
     * @return BaseResponse
     */
    BaseResponse login(String account, String password);
}
