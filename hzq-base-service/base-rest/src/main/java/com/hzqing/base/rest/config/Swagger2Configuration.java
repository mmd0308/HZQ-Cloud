package com.hzqing.base.rest.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                //只有添加了ApiOperation注解的method才在API中显示
                if (input.isAnnotatedWith(ApiOperation.class) || input.isAnnotatedWith(Api.class) || input.isAnnotatedWith(ApiModelProperty.class)){
                    return true;
                }
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.hzqing.base.rest"))
                // 只有添加注解，在页面显示方法的接口
                .apis(predicate)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HZQ-CLOUD-BASE API 文档")
                .description("HZQ-CLOUD-BASE API 网关接口 http://www.hzqing.com")
                .termsOfServiceUrl("http://www.hzqing.com")
                .version("1.0.0")
                .build();
    }
}