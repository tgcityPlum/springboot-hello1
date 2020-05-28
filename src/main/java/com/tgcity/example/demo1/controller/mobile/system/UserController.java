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
 * @description 用户的Controller
 */
@RestController
@RequestMapping("/mobile/user")
@Api(tags = "4、用户模块")
public class UserController {

    @GetMapping("get/parameter/no/1")
    @ApiOperation(value = "get无参测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getData() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }

    /**
     * 1、获取用户信息
     */

    /**
     * 2、修改用户密码
     */

    /**
     * 3、找回用户密码
     */

    /**
     * 4、修改用户信息
     */

}
