package com.hzqing.base.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.AddButtonRequest;
import com.hzqing.base.api.dto.button.ButtonDto;
import com.hzqing.base.api.dto.button.UpdateButtonRequest;
import com.hzqing.base.rest.vo.ButtonVO;
import org.mapstruct.Mapper;

/**
 * @author hzqing
 * @date 2019-08-12 22:07
 */
@Mapper(componentModel = "spring")
public interface ButtonConverter {

    ButtonVO dto2vo(ButtonDto data);

    Page<ButtonVO> dto2Vo(Page<ButtonDto> data);

    AddButtonRequest vo2Dto(ButtonVO buttonVO);

    UpdateButtonRequest vo2UpdateDto(ButtonVO buttonVO);
}
