package com.tgcity.example.demo1.service.common;

import com.tgcity.example.demo1.common.model.response.BaseResponse;

/**
 * @author: TGCity
 * @create: 2020/5/29
 * @description 图片对内接口
 */
public interface FileService {

    /**
     * 1 保存图片
     * @param image String
     */
    BaseResponse saveBase64Image(String image);
}
