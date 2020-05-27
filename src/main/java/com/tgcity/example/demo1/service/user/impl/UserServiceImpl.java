package com.tgcity.example.demo1.service.user.impl;

import com.tgcity.example.demo1.dal.mappers.user.UserMapper;
import com.tgcity.example.demo1.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: TGCity
 * @create: 2020/5/26
 * @description 用户操作向外部的类。可以处理校验
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUserName() throws Exception {
        return userMapper.getUserName(1);
    }
}
