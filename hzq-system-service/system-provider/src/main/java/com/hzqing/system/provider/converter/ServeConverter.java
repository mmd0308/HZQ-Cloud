package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.provider.dal.entity.Serve;
import com.hzqing.system.api.dto.serve.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-13 21:28
 */
@Mapper(componentModel = "spring")
public interface ServeConverter {
    Serve req2Serve(AddServeRequest request);

    ServeDto req2Dto(Serve serve);

    Serve req2Serve(ServeListRequest request);

    List<ServeDto> listServe2ListDto(List<Serve> serves);

    Serve req2Serve(ServePageRequest request);

    Page<ServeDto> pageServe2PageDto(IPage<Serve> serveIPage);

    Serve req2Serve(UpdateServeRequest request);
}
