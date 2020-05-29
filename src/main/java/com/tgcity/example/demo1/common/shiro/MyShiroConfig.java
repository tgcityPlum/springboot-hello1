package com.tgcity.example.demo1.common.shiro;

import com.tgcity.example.demo1.common.shiro.filter.CustomFormAuthenticationFilter;
import com.tgcity.example.demo1.common.shiro.realm.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置文件
 *
 */
@Configuration
public class MyShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("DefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro内置过滤器
        return bean;
    }

    @Bean("DefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("MyShiroRealm") MyShiroRealm userRealm) {
        //@Qualifier 选择和参数中同名的bean
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean("MyShiroRealm")
    public MyShiroRealm getRealm() {
        return new MyShiroRealm();
    }
}
