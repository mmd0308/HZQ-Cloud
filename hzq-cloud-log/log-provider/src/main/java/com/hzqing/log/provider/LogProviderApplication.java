package com.hzqing.log.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hzqing.log.provider.dal.mapper")
public class LogProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogProviderApplication.class, args);
    }

}
