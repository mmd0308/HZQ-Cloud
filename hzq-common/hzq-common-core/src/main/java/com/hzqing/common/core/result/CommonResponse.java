package com.hzqing.common.core.result;

/**
 * @author hzqing
 * @date 2019-08-11 11:16
 */
public class CommonResponse<T> extends AbstractResponse {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
