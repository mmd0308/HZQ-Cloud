package com.hzqing.common.core.rest.controller;

import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.response.CommonResponse;

/**
 * 基础Controller类
 * @author hzqing
 * @date 2019-08-12 22:36
 */
public class BaseController {

    /**
     *  用与只返回成功和失败
     *  没有data数据信息的返回
     * @param response
     * @return
     */
    public RestResult result(CommonResponse response){
        return CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode()) ?
                RestResultFactory.getInstance().success() : RestResultFactory.getInstance().error();
    }
}
