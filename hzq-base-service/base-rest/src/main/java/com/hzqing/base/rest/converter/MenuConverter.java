package com.hzqing.base.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.AddMenuRequest;
import com.hzqing.base.api.dto.menu.MenuDto;
import com.hzqing.base.api.dto.menu.UpdateMenuRequest;
import com.hzqing.base.rest.vo.MenuVO;
import org.mapstruct.Mapper;

/**
 * @author hzqing
 * @date 2019-08-12 22:07
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {
    MenuVO dto2vo(MenuDto data);

    Page<MenuVO> pageDto2PageVo(Page<MenuDto> data);

    UpdateMenuRequest vo2UpdateDto(MenuVO menuVO);

    AddMenuRequest vo2Dto(MenuVO menuVO);
}
