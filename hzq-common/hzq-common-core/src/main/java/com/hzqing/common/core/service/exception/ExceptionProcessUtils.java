package com.hzqing.common.core.service.exception;


import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.response.AbstractResponse;

/**
 * @author hzqing
 * @date 2019-08-11 08:57
 */
public class ExceptionProcessUtils {
    /**
     * 出现异常，根据异常，设置错误返回码及提示信息
     * @param response
     * @param e
     */
    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionConvertUtils.convertException2Biz(response,e);
        } catch (Exception ex){
            response.setCode(CommonRetCodeConstants.SERVICE_ERROR.getCode());
            response.setMsg(CommonRetCodeConstants.SERVICE_ERROR.getMsg());
        }
    }
}
