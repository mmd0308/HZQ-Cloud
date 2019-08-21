package com.hzqing.base.rest.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class Swagger2Configuration {

    @Value("${security.oauth2.client.access-token-uri")
    private String authServe;

    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = input -> {
            //只有添加了ApiOperation注解的method才在API中显示
            if (input.isAnnotatedWith(ApiOperation.class) || input.isAnnotatedWith(Api.class) || input.isAnnotatedWith(ApiModelProperty.class)){
                return true;
            }
            return false;
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.hzqing.base.rest"))
                // 只有添加注解，在页面显示方法的接口
                .apis(predicate)
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HZQ-CLOUD-BASE API 文档")
                .description("HZQ-CLOUD-BASE API 网关接口 http://www.hzqing.com")
                .termsOfServiceUrl("http://www.hzqing.com")
                .version("1.0.0")
                .build();
    }

    /**
     * 这个类决定了你使用哪种认证方式，我这里使用密码模式
     * 其他方式自己摸索一下，完全莫问题啊
     */
    private SecurityScheme securityScheme() {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(authServe);
        return new OAuthBuilder()
                .name("password_scheme")
                .grantTypes(Collections.singletonList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    /**
     * 这里设置 swagger2 认证的安全上下文
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("password_scheme", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }

    /**
     * 这里是写允许认证的scope
     */
    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("app", "默认scope")
        };
    }
}