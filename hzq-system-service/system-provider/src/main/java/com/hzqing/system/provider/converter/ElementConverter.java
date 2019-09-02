package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.provider.dal.entity.Element;
import com.hzqing.system.api.dto.button.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 按钮模块实体和dto转换器
 * @author hzqing
 * @date 2019-08-13 21:24
 */
@Mapper(componentModel = "spring")
public interface ElementConverter {

    Element req2Button(AddElementRequest request);

    ElementDto req2Dto(Element button);

    List<ElementDto> listButton2ListDto(List<Element> buttons);

    Element req2Button(UpdateElementRequest request);

    Page<ElementDto> pageButton2PageDto(IPage<Element> buttonIPage);

    Element req2Button(ElementPageRequest request);

    Element req2Button(ElementListRequest request);
}
