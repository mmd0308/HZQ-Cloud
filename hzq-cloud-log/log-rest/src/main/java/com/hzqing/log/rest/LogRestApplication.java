package com.hzqing.log.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 日志restful 接口启动类
 * @author hzq
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LogRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogRestApplication.class, args);
    }

}
