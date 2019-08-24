package com.hzqing.cloud.log.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author hzqing
 * @date 2019-08-21 20:02
 */
@Configuration
@EnableResourceServer
@Order(-1)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true) //全局方法拦截
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .cors()
            .and()
            .csrf().disable()
                .headers().frameOptions().disable() //允许网页iframe
                .and()
            .authorizeRequests()
            // 以下为配置所需保护的资源路径及权限，需要与认证服务器配置的授权部分对应
            //.antMatchers("/hello").hasAuthority("Hello")
            .antMatchers(
                    "/webjars/**",
                    "/resources/**",
                    "/swagger-ui.html",
                    "/swagger-resources/**",
                    "/v2/api-docs")
            .permitAll()
            .antMatchers("/**").authenticated();
    }
}
