package com.hzqing.cloud.log.api.dto;

import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-19 14:34
 */
@Data
public class AddLoginLogRequest extends AbstractRequest {


    /**
     * 登陆账号
     */
    private String loginName;

    /**
     * 登陆ip
     */
    private String ip;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 登陆时间
     */
    private LocalDateTime createTime;

    @Override
    public void checkParams() {

    }
}
