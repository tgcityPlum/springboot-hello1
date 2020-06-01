package com.tgcity.example.demo1.service.river;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.dal.entity.RiverEntity;

/**
 * @author: TGCity
 * @create: 2020/6/1
 * @description 河流向外部提供的接口
 */
public interface RiverService {

    /**
     * 1 添加河流
     * @param riverEntityList RiverEntity
     * @return BaseResponse
     */
    BaseResponse add(RiverEntity riverEntityList);
}
