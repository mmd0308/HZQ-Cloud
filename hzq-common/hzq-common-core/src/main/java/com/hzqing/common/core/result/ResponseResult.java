package com.hzqing.common.core.result;

/**
 * rest
 * 消费端调用返回的信息格式
 * @author hzqing
 * @date 2019-08-09 23:51
 */
public class ResponseResult<T> {
    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应状态吗
     */
    private int code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 响应信息
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
