package com.tgcity.example.demo1.controller.test.database;

import com.tgcity.example.demo1.dal.entity.user.UserEntity;
import com.tgcity.example.demo1.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@Api(tags = "2、测试数据库连接")
public class TestDatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    /**
     * 测试数据库连接情况
     */
    @GetMapping("/getData")
    @ApiOperation(value = "jdbcTemplate连接测试", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, Object>> getData() {
        String sql = "SELECT * FROM `user`;";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 测试Mybatis连接数据库
     * 获取用户账号
     */
    @GetMapping("/getMybatisData")
    @ApiOperation(value = "获取用户名", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
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
    @ApiOperation(value = "获取用户列表", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> getAllUsers() {
        try {
            return userService.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
