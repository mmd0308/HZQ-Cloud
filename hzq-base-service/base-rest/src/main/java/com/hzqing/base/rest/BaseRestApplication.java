package com.hzqing.base.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@ComponentScan({"com.hzqing.base.rest","com.hzqing.common.rest"})
public class BaseRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseRestApplication.class, args);
    }

}
