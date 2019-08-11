package com.hzqing.base.api.constants;

/**
 * @author hzqing
 * @date 2019-08-10 00:45
 */
public enum UserRetCodeConstants {

    INVALID_PARAMETER                   ("INVALID_PARAMETER","请求参数缺失！");

    private String code;

    private String msg;

    UserRetCodeConstants(String code, String msg) {
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
