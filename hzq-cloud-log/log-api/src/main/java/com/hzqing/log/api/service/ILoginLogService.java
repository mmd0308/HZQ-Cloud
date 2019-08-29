package com.hzqing.log.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.log.api.dto.AddLoginLogRequest;
import com.hzqing.log.api.dto.LoginLogDto;
import com.hzqing.common.core.service.request.PageRequest;
import com.hzqing.common.core.service.response.CommonResponse;

/**
 * 用户登陆日志
 * @author hzqing
 * @date 2019-08-19 14:31
 */
public interface ILoginLogService {

    /**
     *  新增登陆日志
     * @param request
     * @return›
     */
    CommonResponse save(AddLoginLogRequest request);

    /**
     * 根据条件获取登陆日志分页列表
     * @param request
     * @return
     */
    CommonResponse<Page<LoginLogDto>> page(PageRequest request);


}
