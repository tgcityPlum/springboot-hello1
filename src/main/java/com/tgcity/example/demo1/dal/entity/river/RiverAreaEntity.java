package com.tgcity.example.demo1.dal.entity.river;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tgcity.example.demo1.dal.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/6/2
 * @description 河流区域实体类
 */
@Data
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
@TableName("w_river_area")
@ApiModel(description = "河流区域实体类")
public class RiverAreaEntity extends BaseEntity {

    @ApiModelProperty(name = "area_id", value = "区域id")
    @TableField(value = "area_id")
    private String areaId;

    @ApiModelProperty(name = "river_id", value = "河流的id")
    @TableField(value = "river_id")
    private Integer riverId;

}
