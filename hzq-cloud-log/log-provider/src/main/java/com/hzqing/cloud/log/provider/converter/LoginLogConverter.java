package com.hzqing.cloud.log.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.cloud.log.api.dto.AddLoginLogRequest;
import com.hzqing.cloud.log.api.dto.LoginLogDto;
import com.hzqing.cloud.log.provider.dal.entity.LoginLog;
import org.mapstruct.Mapper;

/**
 * 按钮模块实体和dto转换器
 * @author hzqing
 * @date 2019-08-13 21:24
 */
@Mapper(componentModel = "spring")
public interface LoginLogConverter {

    LoginLog req2LoginLog(AddLoginLogRequest request);

    Page<LoginLogDto> page2pageDto(IPage<LoginLog> logIPage);
}
