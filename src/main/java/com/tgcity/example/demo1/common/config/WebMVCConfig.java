package com.tgcity.example.demo1.common.config;


import com.tgcity.example.demo1.common.interceptor.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 映射配置文件
 */
@Configuration
@Slf4j
public class WebMVCConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/water/**")
                .addResourceLocations("file:C:/home/xietong/files/water/");
        super.addResourceHandlers(registry);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

//    /**
//     * 跨域
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }

}
