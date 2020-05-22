package com.tgcity.example.demo1.controller.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: TGCit
 * @create: 2020/5/22
 * @description 测试控制器
 */
@RestController
@RequestMapping("/hello")
@Api(tags = "测试控制器-hello")
public class HelloController {

    @GetMapping("/string")
    @ApiOperation(value = "返回string",httpMethod = "GET",consumes = "application/json")
    public String getHello(){
        return "{'code':1,'message':'请求成功'}";
    }
}
