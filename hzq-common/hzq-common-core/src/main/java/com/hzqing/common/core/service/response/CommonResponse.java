package com.hzqing.common.core.service.response;

import lombok.Data;
import lombok.ToString;

/**
 * 服务提供者通用的响应类
 * @author hzqing
 * @date 2019-08-11 11:16
 */
@Data
@ToString(callSuper = true)
public class CommonResponse<T> extends AbstractResponse {
    /**
     * 响应的数据
     */
    private T data;

}
