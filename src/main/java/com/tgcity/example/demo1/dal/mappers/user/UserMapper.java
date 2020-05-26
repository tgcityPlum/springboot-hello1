package com.tgcity.example.demo1.dal.mappers.user;

import com.tgcity.example.demo1.dal.entity.user.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TGCity
 * @create: 2020/5/26
 * @description 用户查询数据库的接口
 */

@Repository
public interface UserMapper {

    /**
     * 获取所有用户
     *
     * @return List<UserEntity>
     */
    List<UserEntity> getUserList();
}
