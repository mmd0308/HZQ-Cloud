package com.hzqing.common.core.result;

import com.hzqing.common.core.constants.ResponseResultConstants;

/**
 * rest
 * ResponseResult 工厂类
 * @author hzqing
 * @date 2019-08-10 00:03
 */
public class ResponseResultFactory<T> {

    private ResponseResult<T> responseResult;

    public ResponseResultFactory() {
        responseResult = new ResponseResult<T>();
        responseResult.setCode(200);
        responseResult.setSuccess(true);
        responseResult.setMessage("success");
    }

    /**
     * 响应成功的结果集
     * @return
     */
    public ResponseResult<T> resultSuccess(T t){
        this.responseResult.setData(t);
        return this.responseResult;
    }

    /**
     * 请求成功，返回数据及提示信息
     * @param t
     * @param msg
     * @return
     */
    public ResponseResult<T> resultSuccess(T t,String msg){
        this.responseResult.setData(t);
        this.responseResult.setMessage(msg);
        return this.responseResult;
    }

    /**
     * 请求失败，返回错误提示信息
     * @param msg
     * @return
     */
    public ResponseResult<T> resultError(String msg){
        this.responseResult.setSuccess(false);
        this.responseResult.setCode(500);
        this.responseResult.setMessage(msg);
        return this.responseResult;
    }




}
