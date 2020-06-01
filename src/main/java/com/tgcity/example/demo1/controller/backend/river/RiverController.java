package com.tgcity.example.demo1.controller.backend.river;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.dal.entity.RiverEntity;
import com.tgcity.example.demo1.service.river.RiverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: TGCity
 * @create: 2020/6/1
 * @description 后台河流模块的Controller
 */
@RestController
@RequestMapping("/backend/river")
@Api(tags = "1、河流模块")
public class RiverController {

    @Autowired
    private RiverService riverService;

    /**
     * 1、添加河流
     */
    @PostMapping("add")
    @ApiOperation(value = "添加河流", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "request", value = "请求体", required = true, dataType = "RiverEntity")
    public BaseResponse add(@RequestBody RiverEntity request) {
        return riverService.add(request);
    }
}
