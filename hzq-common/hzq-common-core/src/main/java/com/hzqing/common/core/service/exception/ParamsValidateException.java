package com.hzqing.common.core.service.exception;

/**
 * @author hzqing
 * @date 2019-08-10 18:52
 */
public class ParamsValidateException extends BaseException {


    private static final long serialVersionUID = 770371358256720192L;

    public ParamsValidateException(String code, String msg) {
        super(code, msg);
    }

}
