package com.tgcity.example.demo1.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: TGCity
 * @create: 2020/5/27
 * @description Swagger的配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 定义分隔符,配置Swagger多包
     */
    private static final String CONTROLLER_PATH = "com.tgcity.example.demo1.controller";

    @Bean
    public Docket createMobileRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("移动端接口")
                .apiInfo(apiInfo("Water Mobile Rest Api", "水务移动端接口","1.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PATH))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("/mobile.*"))
                .build();
    }

    @Bean
    public Docket createFrontEndRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("前端接口")
                .apiInfo(apiInfo("Water Front End Rest Api", "水务前端接口","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PATH))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("/frontend.*"))
                .build();
    }

    @Bean
    public Docket createBackEndRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后端接口")
                .apiInfo(apiInfo("Water Front End Rest Api", "水务后端接口","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PATH))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("/backend.*"))
                .build();
    }

    private ApiInfo apiInfo(String title, String description, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl("")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version(version)
                .build();
    }

}
