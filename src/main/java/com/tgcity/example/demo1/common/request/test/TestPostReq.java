package com.tgcity.example.demo1.common.request.test;

import lombok.Data;

/**
 * @author: TGCity
 * @create: 2020/5/25
 * @description post请求体测试类
 */
@Data
public class TestPostReq {

    /**
     * 页码
     */
    private int pageNo;
    /**
     * 数量
     */
    private int pageSize;

}
