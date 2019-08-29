package com.hzqing.log.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.log.api.dto.AddOperationLogRequest;
import com.hzqing.log.api.dto.OperationLogDto;
import com.hzqing.common.core.service.request.PageRequest;
import com.hzqing.common.core.service.response.CommonResponse;

/**
 * 用户操作相关日志
 * @author hzqing
 * @date 2019-08-19 14:32
 */
public interface IOperationLogService {
    /**
     *  新增操作日志
     * @param request
     * @return›
     */
    CommonResponse save(AddOperationLogRequest request);

    /**
     * 根据条件获取操作日志分页列表
     * @param request
     * @return
     */
    CommonResponse<Page<OperationLogDto>> page(PageRequest request);


}
