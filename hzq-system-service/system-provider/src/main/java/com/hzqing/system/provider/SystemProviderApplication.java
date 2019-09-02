package com.hzqing.system.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzqing.system.provider.dal.mapper")
public class SystemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemProviderApplication.class, args);
    }

}
