package com.tgcity.example.demo1.dal.mappers.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tgcity.example.demo1.dal.entity.system.AccountEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 账户查询数据库的接口
 */
@Repository
public interface AccountMapper extends BaseMapper<AccountEntity> {

    List<AccountEntity> getAccountList(@Param("user_account") String userAccount);
}
