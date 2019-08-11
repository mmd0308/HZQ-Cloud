package com.hzqing.common.core.rest.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {
    /**
     * 请求响应码
     */
    private String code;

    /**
     * 响应吗对应的提示信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private RestResultData<T> data;


    public RestResult(String code, String msg, T attributes) {
        this.code = code;
        this.msg = msg;
        this.data = createBaseResultData(attributes);
    }

    public RestResultData<T> createBaseResultData(T attributes){
        RestResultData<T> data = new RestResultData<>();
        data.setAttributes(attributes);
        return data;
    }

}
