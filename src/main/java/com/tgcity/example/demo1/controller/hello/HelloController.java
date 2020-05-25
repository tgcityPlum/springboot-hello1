package com.tgcity.example.demo1.controller.hello;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: TGCit
 * @create: 2020/5/22
 * @description 测试控制器
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试控制器-hello")
@Slf4j
public class HelloController {

    @GetMapping("/getData")
    @ApiOperation(value = "get返回string", httpMethod = "GET", consumes = "application/json")
    public String getData() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 1);
        map.put("message", "get返回Data成功");
        return JSONObject.toJSONString(map);
    }

    @PostMapping(value = "/postDate", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "post返回string", httpMethod = "POST", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

}
