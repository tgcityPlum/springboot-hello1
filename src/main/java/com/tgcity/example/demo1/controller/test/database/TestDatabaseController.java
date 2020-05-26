package com.tgcity.example.demo1.controller.test.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: TGCity
 * @create: 2020/5/26
 * @description 测试数据库连接
 */
@RestController
@RequestMapping("/test/database")
public class TestDatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 测试数据库连接情况
     */
    @GetMapping("/getData")
    public List<Map<String, Object>> getData() {
        String sql = "SELECT * FROM `user`;";
        return jdbcTemplate.queryForList(sql);
    }
}
