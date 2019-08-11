package com.hzqing.common.core.service.constants;

/**
 * 服务调用通用响应吗
 * 用于服务数据返回的状态吗，及提示信息
 * @author hzqing
 * @date 2019-08-11 20:15
 */
public enum CommonRetCodeConstants {

    SUCCESS                             ("SUCCESS","成功！"),
    SERVICE_ERROR                       ("SERVICE_ERROR","服务繁忙！"),
    INVALID_PARAMETER                   ("INVALID_PARAMETER","请求参数缺失！");



    private String code;

    private String msg;

    CommonRetCodeConstants(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
