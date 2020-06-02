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
 * @description 河流河长实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@TableName("w_river_manager")
@ApiModel(description = "河流河长实体类")
public class RiverManagerEntity extends BaseEntity {

    private static final long serialVersionUID = 8L;

    @ApiModelProperty(name = "river_id", value = "河流的id")
    @TableField(value = "river_id")
    private Integer riverId;

    @ApiModelProperty(name = "level", value = "河长的等级|一级|二级|三级|四级")
    @TableField(value = "level")
    private Integer level;

    @ApiModelProperty(name = "manager_id", value = "河长的id")
    @TableField(value = "manager_id")
    private String managerId;

}
