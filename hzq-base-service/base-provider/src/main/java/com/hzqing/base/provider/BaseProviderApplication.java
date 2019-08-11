package com.hzqing.base.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzqing.base.provider.dal.mapper")
public class BaseProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseProviderApplication.class, args);
    }

}
