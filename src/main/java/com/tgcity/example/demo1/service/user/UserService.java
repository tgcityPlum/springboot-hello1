package com.tgcity.example.demo1.service.user;

import com.tgcity.example.demo1.dal.entity.user.UserEntity;

import java.util.List;

/**
 * @author: TGCity
 * @create: 2020/5/26
 * @description 用户向外部提供的接口
 */
public interface UserService {

    /**
     * 获取所有用户
     *
     * @return List<UserEntity>
     * @throws Exception Exception
     */
    List<UserEntity> getUserList() throws Exception;
}
