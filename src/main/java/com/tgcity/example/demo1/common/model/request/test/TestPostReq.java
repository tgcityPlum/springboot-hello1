package com.tgcity.example.demo1.common.model.request.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: TGCity
 * @create: 2020/5/25
 * @description post请求体测试类
 */
@Data
@ApiModel(description = "测试表单")
public class TestPostReq {

    @ApiModelProperty(name = "pageNo", value = "页码", required = false, example = "1")
    private int pageNo;

    @ApiModelProperty(name = "pageSize",value = "数量",required = true,example = "10")
    private int pageSize;

}
