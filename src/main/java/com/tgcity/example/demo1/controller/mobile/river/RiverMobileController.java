package com.tgcity.example.demo1.controller.mobile.river;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.river.SearchRiverResponse;
import com.tgcity.example.demo1.service.river.RiverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: TGCity
 * @create: 2020/6/2
 * @description 移动端河流Controller
 */
@RestController
@RequestMapping("/mobile/river")
@Api(tags = "5、河流模块")
public class RiverMobileController {

    @Autowired
    private RiverService riverService;

    /**
     * 1、搜索河流
     */
    @GetMapping("search")
    @ApiOperation(value = "搜索河流", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "name", value = "河流名称", dataType = "String", required = true)
    public BaseResponse<List<SearchRiverResponse>> search(String name) {
        return riverService.searchRiver(name);
    }

}
