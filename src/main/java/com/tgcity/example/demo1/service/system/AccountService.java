package com.tgcity.example.demo1.service.system;

import com.tgcity.example.demo1.common.model.request.system.RegisterReq;
import com.tgcity.example.demo1.common.model.request.system.ResetPasswordReq;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.system.LoginUserResponse;
import com.tgcity.example.demo1.common.model.response.system.UserInfoResponse;
import com.tgcity.example.demo1.dal.entity.user.QQUserInfo;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 账户信息向外部提供的接口
 */
public interface AccountService {

    /**
     * 1 注册用户
     *
     * @param registerReq RegisterReq
     * @return BaseResponse
     */
    BaseResponse register(RegisterReq registerReq);

    /**
     * 2 用户登录
     *
     * @param account  账号
     * @param password 密码
     * @return BaseResponse<LoginUserResponse>
     */
    BaseResponse<LoginUserResponse> login(String account, String password);

    /**
     * 3 获取用户基本信息
     *
     * @return BaseResponse<UserInfoResponse>
     */
    BaseResponse<UserInfoResponse> userInfo();

    /**
     * 4 修改密码
     *
     * @param request ResetPasswordReq
     * @return BaseResponse
     */
    BaseResponse resetPassword(ResetPasswordReq request);

    /**
     * 5 修改用户信息
     * @param request UserInfoResponse
     * @return BaseResponse
     */
    BaseResponse resetInfo(UserInfoResponse request);

    /**
     * 6 上传头像图片
     * @param avatar String
     * @return BaseResponse
     */
    BaseResponse updateAvatar(String avatar);

    /**
     * 7 获取QQ用户信息
     * @param accessToken String
     * @param openId String
     * @return QQUserInfo
     */
    QQUserInfo getQQUserInfo(String accessToken, String openId);


}
