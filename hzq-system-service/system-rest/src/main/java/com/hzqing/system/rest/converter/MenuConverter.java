package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.rest.vo.MenuTreeVO;
import com.hzqing.system.rest.vo.MenuVO;
import com.hzqing.system.api.dto.menu.*;
import org.mapstruct.Mapper;

import java.util.List;

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

    MenuListRequest vo2ListDto(MenuVO menuVO);

    List<MenuVO> dto2vo(List<MenuDto> data);

    MenuTreeRequest vo2TreeDto(MenuVO menuVO);

    List<MenuTreeVO> dto2Treevo(List<MenuTreeDto> data);
}
