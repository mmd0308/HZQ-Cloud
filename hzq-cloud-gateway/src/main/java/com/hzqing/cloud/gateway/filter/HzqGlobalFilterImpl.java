package com.hzqing.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author hzqing
 * @date 2019-08-20 16:36
 */
@Slf4j
@Component
public class HzqGlobalFilterImpl implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("HzqGlobalFilterImpl.interceptor " );
        log.info("HzqGlobalFilterImpl.interceptor 进入过滤器");

        ServerHttpResponse response = exchange.getResponse();
        log.info("HzqGlobalFilterImpl.interceptor " + response);
        return chain.filter(exchange);
    }



    @Override
    public int getOrder() {
        return -10;
    }
}
