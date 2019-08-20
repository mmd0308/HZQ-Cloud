package com.hzqing.cloud.log.api.dto;

import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-19 14:38
 */
@Data
public class AddOperationLogRequest extends AbstractRequest {

    /**
     * 操作人
     */
    private String loginName;

    /**
     * 请求的路径
     */
    private String url;

    /**
     * Ip地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 操作时间
     */
    private LocalDateTime createTime;

    @Override
    public void checkParams() {

    }
}
