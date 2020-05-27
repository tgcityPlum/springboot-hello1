package com.tgcity.example.demo1.controller.mobile.test;

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
@RequestMapping("/mobile/test/stable")
@Api(tags = "1、常见请求的测试")
@Slf4j
public class StableController {

    /**
     * 直接get请求测试
     */
    @GetMapping("get/parameter/no")
    @ApiOperation(value = "get无参测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getData() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }

    /**
     * 携参方式一get请求测试
     *
     * @param phone string
     */
    @GetMapping("get/parameter/static")
    @ApiOperation(value = "get携参测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "phone", value = "手机号", dataType = "string", required = true)
    public String getDataParamStyleOne(@RequestParam("phone") String phone) {
        log.info("phone=" + phone);
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }

    /**
     * 携参方式二get请求测试
     *
     * @param phone string
     */
    @GetMapping("get/parameter/dynamic/{phone}")
    @ApiOperation(value = "get动态携参测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getDataParamStyleTwo(@PathVariable("phone") String phone) {
        log.info("phone=" + phone);
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }

    /**
     * 携参post测试
     *
     * @param pageNo   int
     * @param pageSize int
     */
    @PostMapping(value = "post/parameter", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "post多参测试", httpMethod = "POST", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNo", value = "页号", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "数量", dataType = "int", required = true)
    })
    public String postData(int pageNo, int pageSize) {
        log.info("pageNo=" + pageNo + ",pageSize=" + pageSize);
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "post返回Data成功");
        return JSONObject.toJSONString(map);
    }

    /**
     * 携对象post测试
     *
     * @param testPostReq TestPostReq
     */
    @PostMapping(value = "post/body")
    @ApiOperation(value = "post对象测试", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "testPostReq",value = "请求体",dataType = "TestPostReq",required = true)
    public String postDataBody(@RequestBody TestPostReq testPostReq) {
        log.info("testPostReq=" + testPostReq.toString());
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "post返回Data成功");
        return JSONObject.toJSONString(map);
    }

}
