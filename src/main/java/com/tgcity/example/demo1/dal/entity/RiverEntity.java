package com.tgcity.example.demo1.dal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/6/1
 * @description 河流实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@TableName("w_river")
@ApiModel(description = "河流实体类")
public class RiverEntity extends BaseEntity{

    private static final long serialVersionUID = 3L;

    @ApiModelProperty(name = "river_code", value = "河体编号")
    @TableField(value = "river_code")
    private String riverCode;

    @ApiModelProperty(name = "river_name", value = "河道名称")
    @TableField(value = "river_name")
    private String riverName;

    @ApiModelProperty(name = "code", value = "河流的code")
    @TableField(value = "code")
    private String code;

    @ApiModelProperty(name = "river_system", value = "河流所属水系")
    @TableField(value = "river_system")
    private String riverSystem;

    @ApiModelProperty(name = "manage_level", value = "管理级别 村级|镇管|区管|市管")
    @TableField(value = "manage_level")
    private String manageLevel;

    @ApiModelProperty(name = "category", value = "河流的分类：河道|湖泊|其它河湖")
    @TableField(value = "category")
    private String category;

}
