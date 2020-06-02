package com.tgcity.example.demo1.service.river.impl;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.dal.entity.river.AreaEntity;
import com.tgcity.example.demo1.dal.entity.river.ManagerEntity;
import com.tgcity.example.demo1.dal.entity.river.RiverEntity;
import com.tgcity.example.demo1.dal.mappers.river.AreaMapper;
import com.tgcity.example.demo1.dal.mappers.river.ManagerMapper;
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

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public BaseResponse add(RiverEntity entity) {
        riverMapper.insert(entity);
        return BaseResponse.ok().build();
    }

    @Override
    public BaseResponse managerAdd(ManagerEntity request) {
        managerMapper.insert(request);
        return BaseResponse.ok().build();
    }

    @Override
    public BaseResponse areaAdd(AreaEntity request) {
        areaMapper.insert(request);
        return BaseResponse.ok().build();
    }
}
