package com.hzqing.common.rest.interceptor;

import com.alibaba.fastjson.JSON;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.log.api.dto.AddOperationLogRequest;
import com.hzqing.log.api.service.IOperationLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * 日志拦截器，记录操作日志，登陆日志信息
 * @author hzqing
 * @date 2019-08-26 08:05
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    public final static String BASE_PAHT =  "/api/base";

    @Reference(
            version = GlobalConstants.VERSION_V1,
            async = true // 异步调用
    )
    private IOperationLogService operationLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 新增操作日志
        this.createOperationLog(request);
        return true;
    }


    public void createOperationLog(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        AddOperationLogRequest operationLog = new AddOperationLogRequest();
        operationLog.setLoginName("待开发...");
        operationLog.setUrl(BASE_PAHT+ request.getServletPath());
        operationLog.setParams(JSON.toJSONString(request.getParameterMap()));
        operationLog.setIp(ip);
        operationLog.setCreateTime(LocalDateTime.now());
        operationLogService.save(operationLog);
    }
}
