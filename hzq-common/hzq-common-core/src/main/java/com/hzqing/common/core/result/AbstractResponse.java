package com.hzqing.common.core.result;

import com.hzqing.common.core.constants.ResponseResultConstants;
import com.hzqing.common.core.constants.SysRetCodeConstants;

import java.io.Serializable;

/**
 * 内部服务请求响应抽象类
 * @author hzqing
 * @date 2019-08-09 23:49
 */
public abstract class AbstractResponse implements Serializable {
    private static final long serialVersionUID = -8506800861153222507L;

    /**
     * 请求响应码 默认是成功
     */
    private String code = SysRetCodeConstants.SUCCESS.getCode();

    /**
     * 返回信息  默认是成功提示
     */
    private String msg = SysRetCodeConstants.SUCCESS.getMsg();



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

    @Override
    public String toString() {
        return "AbstractResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
