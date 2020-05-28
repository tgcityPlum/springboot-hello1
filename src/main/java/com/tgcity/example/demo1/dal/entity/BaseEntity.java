package com.tgcity.example.demo1.dal.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 逻辑删除的父类
 *
 * @author Leng
 * @since 2019-08-12
 */
@Data
@Accessors(chain = true)
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 逻辑删除标记
     */
    @TableLogic
    @TableField(value = "deleted",fill = FieldFill.INSERT)
    private Boolean deleted;

    /**
     * 乐观锁标记
     */
    @Version
    @TableField(value = "version")
    private Long version;
    /**
     * 创建人
     */
    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "updater", fill = FieldFill.INSERT_UPDATE)
    private String updater;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "comments")
    private String comments;

}
