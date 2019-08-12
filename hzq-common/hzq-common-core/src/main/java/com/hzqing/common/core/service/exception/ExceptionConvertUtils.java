package com.hzqing.common.core.service.exception;


import com.hzqing.common.core.service.response.AbstractResponse;

/**
 * @author hzqing
 * @date 2019-08-11 09:00
 */
public class ExceptionConvertUtils {
    public static AbstractResponse convertException2Biz(AbstractResponse response, Exception e) throws Exception {
        if (!(e instanceof Exception)){
            return null;
        }

        // 参数异常
        if (e instanceof ParamsValidateException){
            response.setCode(((ParamsValidateException) e).getCode());
            response.setMsg(((ParamsValidateException) e).getMsg());
        } else if (e instanceof Exception) {
            // 该异常服务端处理不了，扔给服务调用者
            throw e;
        }

        return response;
    }
}
