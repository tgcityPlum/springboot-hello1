package com.tgcity.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: TGCit
 * @create: 2020/5/22
 * @description 测试控制器
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getHello(){
        return "{'code':1,'message':'请求成功'}";
    }
}
