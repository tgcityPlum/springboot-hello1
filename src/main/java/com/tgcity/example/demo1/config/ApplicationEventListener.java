package com.tgcity.example.demo1.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author: TGCity
 * @create: 2020/5/22
 * @description 启动监听
 */
@Component
public class ApplicationEventListener implements ApplicationListener {

    private static final Log log = LogFactory.getLog(ApplicationEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
            log.info("----------------------------------- 应用初始化环境变量 --------------------------------------");
        } else if (applicationEvent instanceof ApplicationPreparedEvent) {
            log.info("----------------------------------- 初始化完成       ---------------------------------------");
        } else if (applicationEvent instanceof ContextRefreshedEvent) {
            log.info("----------------------------------- 应用刷新完成       -------------------------------------");
        } else if (applicationEvent instanceof ApplicationReadyEvent) {
            String host = "";
            try {
                host = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                host = e.toString();
            }
            log.info("host = " + host);
            log.info("----------------------------------- 应用启动完成       -------------------------------------");
        } else if (applicationEvent instanceof ContextStartedEvent) {
            log.info("----------------------------------- 应用开始启动       -------------------------------------");
        } else if (applicationEvent instanceof ContextStoppedEvent) {
            log.info("----------------------------------- 应用停止       -----------------------------------------");
        } else if (applicationEvent instanceof ContextClosedEvent) {
            log.info("----------------------------------- 应用关闭       -----------------------------------------");
        }

    }
}
