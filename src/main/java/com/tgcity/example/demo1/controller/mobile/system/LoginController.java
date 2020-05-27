package com.tgcity.example.demo1.controller.mobile.system;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: TGCity
 * @create: 2020/5/27
 * @description 登录模块的controller
 */
@RestController
@RequestMapping("/mobile/system/login")
@Api(tags = "3、系统接口", value = "登录模块")
public class LoginController {
    /**
     * 1、校验用户是否存在
     */
    /**
     * 直接get请求测试
     */
    @GetMapping("get/parameter/no/2")
    @ApiOperation(value = "get无参测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getData() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }
    /**
     * 2、注册用户
     */

    /**
     * 3、获取用户信息
     */

    /**
     * 4、修改用户密码
     */

    /**
     * 5、找回用户密码
     */

    /**
     * 7、退出登录
     */
}
