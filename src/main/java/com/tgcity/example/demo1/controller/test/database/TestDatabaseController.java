package com.tgcity.example.demo1.controller.test.database;

import com.tgcity.example.demo1.dal.entity.user.UserEntity;
import com.tgcity.example.demo1.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Autowired
    private UserService userService;

    /**
     * 测试数据库连接情况
     */
    @GetMapping("/getData")
    public List<Map<String, Object>> getData() {
        String sql = "SELECT * FROM `user`;";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 测试Mybatis连接数据库
     * 获取用户账号
     */
    @GetMapping("/getMybatisData")
    public String getMybatisData() {
        try {
            return userService.getUserName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 获取用户列表
     */
    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        try {
            return userService.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
