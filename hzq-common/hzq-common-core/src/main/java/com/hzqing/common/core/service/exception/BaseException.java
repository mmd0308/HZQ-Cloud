package com.hzqing.common.core.service.exception;

/**
 * 基础异常类
 * @author hzqing
 * @date 2019-08-10 18:47
 */
public class BaseException extends RuntimeException{

    /**
     * 异常状态码
     */
    private String code;

    /**
     * 错误提示信息
     */
    private String msg;

    public BaseException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
