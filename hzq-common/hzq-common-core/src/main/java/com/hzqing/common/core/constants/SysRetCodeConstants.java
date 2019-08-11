package com.hzqing.common.core.constants;

/**
 * @author hzqing
 * @date 2019-08-11 09:07
 */
public enum  SysRetCodeConstants {
    SUCCESS             ("SUCCESS","成功!"),
    SYS_ERROR   ("SYS_ERROR","系统错误!");


    private String code;

    private String msg;

    SysRetCodeConstants(String code, String msg) {
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
