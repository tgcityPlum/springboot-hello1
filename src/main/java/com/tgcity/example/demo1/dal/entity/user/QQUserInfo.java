package com.tgcity.example.demo1.dal.entity.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: TGCity
 * @create: 2020/6/5
 * @description QQ实体类
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
@ApiModel(description = "QQ实体类")
public class QQUserInfo {
    private Integer ret;
    private String msg;
    private Integer is_lost;
    private String nickname;
    private String gender;
    private String province;
    private String city;
    private String year;
    private String constellation;
    private String figureurl;
    private String figureurl_1;
    private String figureurl_2;
    private String figureurl_qq;
    private String figureurl_qq_1;
    private String figureurl_qq_2;
    private String is_yellow_vip;
    private String vip;
    private String yellow_vip_level;
    private String level;
    private String is_yellow_year_vip;

}
