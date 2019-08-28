package com.hzqing.cloud.log.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.cloud.log.api.dto.AddOperationLogRequest;
import com.hzqing.cloud.log.api.dto.OperationLogDto;
import com.hzqing.cloud.log.api.service.IOperationLogService;
import com.hzqing.cloud.log.provider.converter.OperationLogConverter;
import com.hzqing.cloud.log.provider.dal.entity.LoginLog;
import com.hzqing.cloud.log.provider.dal.entity.OperationLog;
import com.hzqing.cloud.log.provider.dal.mapper.OperationLogMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.PageRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 日志操作实现类
 * @author hzqing
 * @date 2019-08-19 14:43
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V1)
public class OperationLogServiceImpl implements IOperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Autowired
    private OperationLogConverter operationLogConverter;

    @Override
    public CommonResponse save(AddOperationLogRequest request) {
        log.info("OperationLogServiceImpl.save request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            OperationLog operationLog = operationLogConverter.req2OperationLog(request);
            int row = operationLogMapper.insert(operationLog);
            log.info("OperationLogServiceImpl.save effect row: " + row);
        }catch (Exception e){
            log.error("OperationLogServiceImpl.save occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Page<OperationLogDto>> page(PageRequest request) {
        log.info("OperationLogServiceImpl.page request: " + request);
        CommonResponse<Page<OperationLogDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            IPage<OperationLog> logIPage = operationLogMapper.selectPage(
                    new Page<OperationLog>(request.getPageNum(), request.getPageSize()),
                    new QueryWrapper<>(new OperationLog()));
            Page<OperationLogDto> logDtoPage = operationLogConverter.page2pageDto(logIPage);
            response.setData(logDtoPage);
        } catch (Exception e) {
            log.error("OperationLogServiceImpl.page occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

}
