package com.tgcity.example.demo1.service.river;

import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.dal.entity.river.AreaEntity;
import com.tgcity.example.demo1.dal.entity.river.ManagerEntity;
import com.tgcity.example.demo1.dal.entity.river.RiverAreaEntity;
import com.tgcity.example.demo1.dal.entity.river.RiverEntity;

/**
 * @author: TGCity
 * @create: 2020/6/1
 * @description 河流向外部提供的接口
 */
public interface RiverService {

    /**
     * 1 添加河流
     *
     * @param riverEntityList RiverEntity
     * @return BaseResponse
     */
    BaseResponse add(RiverEntity riverEntityList);

    /**
     * 2、添加管理者
     *
     * @param request ManagerEntity
     * @return BaseResponse
     */
    BaseResponse managerAdd(ManagerEntity request);

    /**
     * 3、添加区域
     *
     * @param request AreaMapper
     * @return BaseResponse
     */
    BaseResponse areaAdd(AreaEntity request);

    /**
     * 4、添加河流区域
     *
     * @param request RiverAreaEntity
     * @return BaseResponse
     */
    BaseResponse riverAreaAdd(RiverAreaEntity request);


}
