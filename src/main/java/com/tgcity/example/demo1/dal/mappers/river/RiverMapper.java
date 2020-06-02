package com.tgcity.example.demo1.dal.mappers.river;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tgcity.example.demo1.common.model.response.river.SearchRiverResponse;
import com.tgcity.example.demo1.dal.entity.river.RiverEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TGCity
 * @create: 2020/6/1
 * @description 河流数据库的接口
 */
@Repository
public interface RiverMapper extends BaseMapper<RiverEntity> {

    /**
     * 1. 搜索河流名称
     * @param name String
     * @return List<SearchRiverResponse>
     */
   List<SearchRiverResponse> searchRiver(String name);

}
