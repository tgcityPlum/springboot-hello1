package com.tgcity.example.demo1.controller.backend.river;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.dal.entity.river.AreaEntity;
import com.tgcity.example.demo1.dal.entity.river.ManagerEntity;
import com.tgcity.example.demo1.dal.entity.river.RiverEntity;
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

    /**
     * 2、添加管理者
     */
    @PostMapping("manager/add")
    @ApiOperation(value = "添加河流", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "request", value = "请求体", required = true, dataType = "ManagerEntity")
    public BaseResponse managerAdd(@RequestBody ManagerEntity request) {
        return riverService.managerAdd(request);
    }

    /**
     * 3、添加区域
     */
    @PostMapping("area/add")
    @ApiOperation(value = "添加区域",httpMethod = "POST",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "areaEntity",value = "请求体",dataType = "AreaEntity",required = true)
    public BaseResponse areaAdd(@RequestBody AreaEntity areaEntity){
        return riverService.areaAdd(areaEntity);
    }

}
