package com.hzqing.auth.service.controller;

import com.hzqing.common.core.constants.GlobalConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 自动定义一些认证获取接口
 * @author hzqing
 * @date 2019-08-17 14:43
 */
@Slf4j
@RestController
@RequestMapping("/"+ GlobalConstants.VERSION_V1 + "/auth/")
public class AuthController {

    @GetMapping("/user")
    public Principal principal(Principal principal){
        log.info("AuthController.principal 获取当前的用户信息：" + principal);
        return principal;
    }

}
