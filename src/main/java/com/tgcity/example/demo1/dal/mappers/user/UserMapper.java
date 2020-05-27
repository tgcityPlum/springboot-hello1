package com.tgcity.example.demo1.dal.mappers.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tgcity.example.demo1.dal.entity.user.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: TGCity
 * @create: 2020/5/26
 * @description 用户查询数据库的接口
 */

@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 获取所有用户
     *
     * @return String
     */
    String getUserName(@Param("id") int id);
}
