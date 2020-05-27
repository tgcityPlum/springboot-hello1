package com.tgcity.example.demo1.controller.backend;

import com.alibaba.fastjson.JSONObject;
import com.tgcity.example.demo1.common.request.test.TestPostReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: TGCit
 * @create: 2020/5/22
 * @description 常见请求的测试
 */
@RestController
@RequestMapping("/backend/test/stable")
@Api(tags = "1、常见请求的测试")
@Slf4j
public class BackTestController {

    /**
     * 直接get请求测试
     */
    @GetMapping("get/parameter/no/5")
    @ApiOperation(value = "get无参测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getData() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }


}
