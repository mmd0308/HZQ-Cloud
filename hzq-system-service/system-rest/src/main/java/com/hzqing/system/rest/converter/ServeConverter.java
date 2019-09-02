package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.serve.AddServeRequest;
import com.hzqing.system.api.dto.serve.ServeDto;
import com.hzqing.system.api.dto.serve.ServeListRequest;
import com.hzqing.system.api.dto.serve.UpdateServeRequest;
import com.hzqing.system.rest.vo.ServeVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-13 21:32
 */
@Mapper(componentModel = "spring")
public interface ServeConverter {
    ServeVO dto2vo(ServeDto data);

    Page<ServeVO> dto2Vo(Page<ServeDto> data);

    AddServeRequest vo2Dto(ServeVO serveVO);

    UpdateServeRequest vo2UpdateDto(ServeVO serveVO);

    ServeListRequest vo2ListDto(ServeVO serveVO);

    List<ServeVO> dto2Vo(List<ServeDto> data);
}
