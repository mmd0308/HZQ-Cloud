package com.hzqing.cloud.gateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author hzqing
 * @date 2019-08-20 16:36
 */
@Slf4j
@Component
public class HzqGlobalFilterImpl implements GlobalFilter, Ordered {

    @Value("${hzqing.cloud.show}")
    private boolean show;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("HzqGlobalFilterImpl.filter " );
        log.info("HzqGlobalFilterImpl.filter 进入过滤器");


        ServerHttpRequest request = exchange.getRequest();
        HttpMethod method = request.getMethod();
        // 是否是演示系统，默认是false
        if (show) {
            // 禁止编辑操作，用于演示系统
            if (!method.matches(HttpMethod.GET.name()) && !request.getPath().value().equals("/api/auth/oauth/token")){
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.OK);
                HashMap<String,String> res = new HashMap<>();
                res.put("code","10500");
                res.put("msg","演示系统，禁止修改");
                byte[] bytes = JSON.toJSONBytes(res);
                log.info("HzqGlobalFilterImpl.filter 演示系统，请求拦截：");
                DataBuffer buffer = response.bufferFactory().wrap(bytes);
                return response.writeWith(Flux.just(buffer));
            }
        }
        return chain.filter(exchange);
    }



    @Override
    public int getOrder() {
        return -10;
    }
}
