package com.hzqing.cloud.log.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LogRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogRestApplication.class, args);
    }

}
