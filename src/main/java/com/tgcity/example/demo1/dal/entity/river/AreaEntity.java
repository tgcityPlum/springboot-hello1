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
 * @description 区域实体类
 */
@Data
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
@TableName("w_area")
@ApiModel(description = "区域实体类")
public class AreaEntity extends BaseEntity {

    @ApiModelProperty(name = "area_id", value = "区域id")
    @TableField(value = "area_id")
    private String areaId;

    @ApiModelProperty(name = "code", value = "区域编码")
    @TableField(value = "code")
    private String code;

    @ApiModelProperty(name = "name", value = "区域名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(name = "grade", value = "区域等级 市、区、镇、村")
    @TableField(value = "grade")
    private Integer grade;

    @ApiModelProperty(name = "parent_id", value = "该区域所属的父区域")
    @TableField(value = "parent_id")
    private String parentId;

}
