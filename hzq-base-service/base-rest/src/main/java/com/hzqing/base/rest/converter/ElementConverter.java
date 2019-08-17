package com.hzqing.base.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.AddElementRequest;
import com.hzqing.base.api.dto.button.ElementDto;
import com.hzqing.base.api.dto.button.ElementListRequest;
import com.hzqing.base.api.dto.button.UpdateElementRequest;
import com.hzqing.base.rest.vo.ElementVO;
import org.mapstruct.Mapper;

/**
 * @author hzqing
 * @date 2019-08-12 22:07
 */
@Mapper(componentModel = "spring")
public interface ElementConverter {

    ElementVO dto2vo(ElementDto data);

    Page<ElementVO> dto2Vo(Page<ElementDto> data);

    AddElementRequest vo2Dto(ElementVO buttonVO);

    UpdateElementRequest vo2UpdateDto(ElementVO buttonVO);

    ElementListRequest vo2ListDto(ElementVO buttonVO);
}
