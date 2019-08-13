package com.hzqing.base.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.*;
import com.hzqing.base.provider.dal.entity.Button;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 按钮模块实体和dto转换器
 * @author hzqing
 * @date 2019-08-13 21:24
 */
@Mapper(componentModel = "spring")
public interface ButtonConverter {
    public Button req2Button(AddButtonRequest request);

    ButtonDto req2Dto(Button button);

    List<ButtonDto> listButton2ListDto(List<Button> buttons);

    Button req2Button(UpdateButtonRequest request);

    Page<ButtonDto> pageButton2PageDto(IPage<Button> buttonIPage);

    Button req2Button(ButtonPageRequest request);

    Button req2Button(ButtonListRequest request);
}
