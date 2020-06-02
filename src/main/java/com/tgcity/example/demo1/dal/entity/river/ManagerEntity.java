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
 * @create: 2020/6/1
 * @description 管理者的实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@TableName("w_manager")
@ApiModel(description = "河流管理者的实体类")
public class ManagerEntity extends BaseEntity {

    private static final long serialVersionUID = 5L;

    @ApiModelProperty(name = "manager_id", value = "河长id")
    @TableField(value = "manager_id")
    private String managerId;

    @ApiModelProperty(name = "manager_name", value = "河长姓名")
    @TableField(value = "manager_name")
    private String managerName;

    @ApiModelProperty(name = "mobile_phone", value = "手机号")
    @TableField(value = "mobile_phone")
    private String mobilePhone;

    @ApiModelProperty(name = "title", value = "河长职务")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(name = "river_level", value = "河长级别，河长| 总河长| 副总河长")
    @TableField(value = "river_level")
    private String riverLevel;

    @ApiModelProperty(name = "admin_level", value = "行政级别")
    @TableField(value = "admin_level")
    private String adminLevel;

    @ApiModelProperty(name = "duty_name", value = "最高职务所在单位")
    @TableField(value = "duty_name")
    private String dutyName;

    @ApiModelProperty(name = "unit_name", value = "单位类别")
    @TableField(value = "unit_name")
    private String unitName;

    @ApiModelProperty(name = "area_id", value = "行政区划河长和行政区的一对一关系")
    @TableField(value = "area_id")
    private String areaId;

    @ApiModelProperty(name = "leader_name", value = "主要领导")
    @TableField(value = "leader_name")
    private String leaderName;

    @ApiModelProperty(name = "is_note", value = "是否公告")
    @TableField(value = "is_note")
    private Boolean isNote;

    @ApiModelProperty(name = "river_type", value = "河长类型")
    @TableField(value = "river_type")
    private String riverType;
}
