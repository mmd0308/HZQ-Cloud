package com.hzqing.auth.service.filter;

import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.log.api.dto.AddLoginLogRequest;
import com.hzqing.log.api.service.ILoginLogService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 日志拦截器，记录操作日志
 * @author hzqing
 * @date 2019-08-26 08:05
 */
@Slf4j
@Component
public class LoginFilter extends OncePerRequestFilter {


    @Reference(
            version = GlobalConstants.VERSION_V1,
            async = true // 异步调用
    )
    private ILoginLogService loginLogService;


    /**
     * 新增操作日志
     * @param request
     */
    public void createLoginLog(HttpServletRequest request){
        String ip = request.getRemoteAddr();

        String userAgentStr = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        Browser browser = userAgent.getBrowser();
        Version browserVersion = browser.getVersion(userAgentStr);
        OperatingSystem os = userAgent.getOperatingSystem();
        String browserName = browser.getName()+"/"+browserVersion;
        String osName = os.getName();

        AddLoginLogRequest loginLog = new AddLoginLogRequest();
        loginLog.setLoginName(request.getParameter("username"));
        loginLog.setIp(ip);
        loginLog.setCreateTime(LocalDateTime.now());
        loginLog.setBrowser(browserName);
        loginLog.setOs(osName);
        loginLog.setMsg("登陆请求,Authorization: " + request.getHeader("Authorization"));
        loginLogService.save(loginLog);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 用户登陆授权
        if (request.getServletPath().equals("/oauth/token")){
            this.createLoginLog(request);
        }
        chain.doFilter(request,response);
    }


}