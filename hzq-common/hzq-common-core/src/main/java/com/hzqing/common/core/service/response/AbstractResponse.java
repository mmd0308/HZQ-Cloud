package com.hzqing.common.core.service.response;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * 内部服务请求响应抽象类
 * @author hzqing
 * @date 2019-08-09 23:49
 */
@Data
public abstract class AbstractResponse implements Serializable {
    private static final long serialVersionUID = -8506800861153222507L;

    /**
     * 请求响应码 默认是成功
     */
    private String code = CommonRetCodeConstants.SUCCESS.getCode();

    /**
     * 返回信息  默认是成功提示
     */
    private String msg = CommonRetCodeConstants.SUCCESS.getMsg();


}
