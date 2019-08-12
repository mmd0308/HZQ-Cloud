package com.hzqing.common.core.rest.result;

import com.hzqing.common.core.rest.constants.RestResultCodeConstants;

/**
 * 创建响应结果对象工厂
 * @author hzqing
 * @date 2019-08-11 15:38
 */
public class RestResultFactory<T> {

    private RestResult baseResult = null;

    public RestResult success(){
        return success(null);
    }

    public RestResult success(T attributes){
        return success(RestResultCodeConstants.SUCCESS.getMsg(),
                attributes);
    }

    public RestResult success(String msg, T attributes){
        return build(RestResultCodeConstants.SUCCESS.getCode(),
                msg,
                attributes);
    }

    public RestResult error(){
        return build(RestResultCodeConstants.SYS_ERROR.getCode(),
                RestResultCodeConstants.SYS_ERROR.getMsg());
    }

    public RestResult error(String msg){
        return build(RestResultCodeConstants.SYS_ERROR.getCode(),
                msg);
    }

    public RestResult build(String code, String msg){
        return build(code,msg,null);
    }

    public RestResult<T> build(String code, String msg, T attributes){
        baseResult = new RestResult(code,msg,attributes);
        return baseResult;
    }


    /**
     * 获取工程实例
     * @return
     */
    public static RestResultFactory getInstance() {
        return InnerResutl.INSTANCE;
    }

    private RestResultFactory() {
    }

    static class InnerResutl{
        private static RestResultFactory INSTANCE = new RestResultFactory();
    }
}
