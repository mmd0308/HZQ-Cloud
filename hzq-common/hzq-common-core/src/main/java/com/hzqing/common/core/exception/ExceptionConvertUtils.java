package com.hzqing.common.core.exception;

import com.hzqing.common.core.result.AbstractResponse;

/**
 * @author hzqing
 * @date 2019-08-11 09:00
 */
public class ExceptionConvertUtils {
    public static AbstractResponse convertException2Biz(AbstractResponse response, Exception e) {
        if (!(e instanceof Exception)){
            return null;
        }

        // 参数异常
        if (e instanceof ParamsValidateException){
            response.setCode(((ParamsValidateException) e).getCode());
            response.setMsg(((ParamsValidateException) e).getMsg());
        }

        return response;
    }
}
