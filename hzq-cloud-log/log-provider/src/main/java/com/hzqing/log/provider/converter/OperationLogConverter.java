package com.hzqing.log.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.log.api.dto.AddOperationLogRequest;
import com.hzqing.log.api.dto.OperationLogDto;
import com.hzqing.log.provider.dal.entity.OperationLog;
import org.mapstruct.Mapper;

/**
 * 按钮模块实体和dto转换器
 * @author hzqing
 * @date 2019-08-13 21:24
 */
@Mapper(componentModel = "spring")
public interface OperationLogConverter {

    OperationLog req2OperationLog(AddOperationLogRequest request);

    Page<OperationLogDto> page2pageDto(IPage<OperationLog> logIPage);
}
