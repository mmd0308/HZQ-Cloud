package com.hzqing.common.core.result;

import java.io.Serializable;

/**
 * 内部服务请求响应抽象类
 * @author hzqing
 * @date 2019-08-09 23:49
 */
public abstract class AbstractResponse implements Serializable {
    private static final long serialVersionUID = -8506800861153222507L;

    /**
     * 请求响应码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;



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
