package com.hzqing.common.core.service.request;

import java.io.Serializable;

/**
 * 请求内部服务的抽象类
 * @author hzqing
 * @date 2019-08-09 23:46
 */
public abstract class AbstractRequest implements Serializable {
    private static final long serialVersionUID = 2946982572412715888L;

    /**
     * 请求参数检查
     */
    public abstract void checkParams();

}
