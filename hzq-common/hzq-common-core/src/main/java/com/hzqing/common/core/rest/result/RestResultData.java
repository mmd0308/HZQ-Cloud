package com.hzqing.common.core.rest.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 定义返回的data数据格式
 * @author hzqing
 * @date 2019-08-11 12:29
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResultData<T> {

    /**
     * 描述数据的类型
     */
    private String type;

    /**
     * 资源具体数据
     */
    private T attributes;

}
