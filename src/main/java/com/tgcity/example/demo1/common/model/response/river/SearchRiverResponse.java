package com.tgcity.example.demo1.common.model.response.river;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/6/2
 * @description 搜索河流返回类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@ApiModel(description = "搜索河流返回类")
public class SearchRiverResponse {

    @ApiModelProperty(name = "riverId", value = "河流id")
    private String riverId;

    @ApiModelProperty(name = "riverName", value = "河流名称")
    private String riverName;

    @ApiModelProperty(name = "name", value = "所属区域")
    private String name;

    @ApiModelProperty(name = "areaId", value = "所属区域id")
    private String areaId;


}
