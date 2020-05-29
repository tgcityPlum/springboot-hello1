package com.tgcity.example.demo1.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.tgcity.example.demo1.common.model.response.system.UserInfoResponse;
import com.tgcity.example.demo1.common.shiro.web.WebContentUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatisplus自定义填充公共字段 ,即没有传的字段自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //新增填充
    @Override
    public void insertFill(MetaObject metaObject) {
        String userName = "匿名";
        //获取当前登录用户
        UserInfoResponse user = WebContentUtil.getAccountInfo();
        if (user != null){
            userName = user.getAccount();
        }
        Date localDateTime = new Date();

        setFieldValByName("updater", userName, metaObject);
        setFieldValByName("updateTime", localDateTime, metaObject);
        setFieldValByName("creator", userName, metaObject);
        setFieldValByName("createTime", localDateTime, metaObject);
        setFieldValByName("deleted", false, metaObject);

//        if (null != metaObject.findProperty("creator",true) &&
//                null == metaObject.getValue("creator")
//        )
//            metaObject.setValue("creator",userName );
//        if (null != metaObject.findProperty("createTime",true) &&
//                null == metaObject.getValue("createTime"))
//            metaObject.setValue("createTime", localDateTime);
//        if (null != metaObject.findProperty("updater",true) &&
//                null == metaObject.getValue("updater"))
//            metaObject.setValue("updater", userName);
//        if (null != metaObject.findProperty("updateTime",true) &&
//                null == metaObject.getValue("updateTime"))
//            metaObject.setValue("updateTime", localDateTime);
    }

    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
        String userName = "匿名";
        //获取当前登录用户
        UserInfoResponse user = WebContentUtil.getAccountInfo();
        if (user != null) {
            userName = user.getAccount();
        }
        Date localDateTime = new Date();
        setFieldValByName("updater", userName, metaObject);
        setFieldValByName("updateTime", localDateTime, metaObject);
    }


}
