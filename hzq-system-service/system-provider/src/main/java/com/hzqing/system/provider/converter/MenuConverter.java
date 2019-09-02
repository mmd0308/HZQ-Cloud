package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.provider.dal.entity.Menu;
import com.hzqing.system.api.dto.menu.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {

    Menu req2Menu(AddMenuRequest request);

    Menu req2Menu(MenuListRequest request);


    MenuDto req2Dto(Menu menu);

    List<MenuDto> listMenu2ListDto(List<Menu> menus);

    Menu req2Menu(UpdateMenuRequest request);

    Menu req2Menu(MenuPageRequest request);

    Page<MenuDto> pageMenu2PageDto(IPage<Menu> menuIPage);

    Menu req2Menu(MenuTreeRequest request);

    List<MenuTreeDto> listMenu2ListTreeDto(List<Menu> menus);
}
