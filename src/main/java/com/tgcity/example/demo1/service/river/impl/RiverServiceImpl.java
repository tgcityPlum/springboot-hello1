package com.tgcity.example.demo1.service.river.impl;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.dal.entity.RiverEntity;
import com.tgcity.example.demo1.dal.mappers.river.RiverMapper;
import com.tgcity.example.demo1.service.river.RiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: TGCity
 * @create: 2020/6/1
 * @description 河流向外部提供的类
 */
@Service
public class RiverServiceImpl implements RiverService {

    @Autowired
    private RiverMapper riverMapper;

    @Override
    public BaseResponse add(RiverEntity entity) {
        riverMapper.insert(entity);
        return BaseResponse.ok().build();
    }
}
