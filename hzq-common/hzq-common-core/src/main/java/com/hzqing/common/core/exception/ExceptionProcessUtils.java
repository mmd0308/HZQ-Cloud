package com.hzqing.common.core.exception;

import com.hzqing.common.core.constants.SysRetCodeConstants;
import com.hzqing.common.core.result.AbstractResponse;

/**
 * @author hzqing
 * @date 2019-08-11 08:57
 */
public class ExceptionProcessUtils {
    /**
     *  出现异常，根据异常，设置错误返回码及提示信息
     * @param response
     * @param e
     */
    public static void wrapperHandlerException(AbstractResponse response,Exception e){
        try {
            ExceptionConvertUtils.convertException2Biz(response,e);
        } catch (Exception ex){
            response.setCode(SysRetCodeConstants.SYS_ERROR.getCode());
            response.setMsg(SysRetCodeConstants.SYS_ERROR.getMsg());
        }
    }
}
