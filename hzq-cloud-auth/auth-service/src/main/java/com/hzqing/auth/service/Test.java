package com.hzqing.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hzqing
 * @date 2019-08-17 14:30
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
