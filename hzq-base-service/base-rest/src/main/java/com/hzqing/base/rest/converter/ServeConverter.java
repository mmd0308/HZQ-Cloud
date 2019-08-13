package com.hzqing.base.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.serve.AddServeRequest;
import com.hzqing.base.api.dto.serve.ServeDto;
import com.hzqing.base.api.dto.serve.UpdateServeRequest;
import com.hzqing.base.rest.vo.ServeVO;
import org.mapstruct.Mapper;

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
}
