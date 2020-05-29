package com.tgcity.example.demo1.common.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @create 2019/7/26 0026 15:27
 */
@Configuration
@PropertySource("classpath:property.yml")
@ConfigurationProperties(prefix = "shiro")
@Data
public class ShiroProperty {

    private String loginUrl;
    private List<Map<String,String>> filterMapList;

}
