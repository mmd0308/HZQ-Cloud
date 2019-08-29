package com.hzqing.auth.service;

import com.hzqing.common.tools.uuid.UUIDUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hzqing
 * @date 2019-08-17 14:30
 */
public class Test {

    public static void main(String[] args) {
        String secret = UUIDUtils.get32UUID();
        System.out.println(secret);
        System.out.println(new BCryptPasswordEncoder().encode("www.hzqing.com"));
    }
}
