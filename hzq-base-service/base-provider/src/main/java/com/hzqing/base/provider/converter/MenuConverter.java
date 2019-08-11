package com.hzqing.base.provider.converter;

import com.hzqing.base.api.dto.menu.*;
import com.hzqing.base.api.dto.role.AddRoleRequest;
import com.hzqing.base.api.dto.role.RoleDto;
import com.hzqing.base.api.dto.role.RoleListRequest;
import com.hzqing.base.api.dto.user.DeleteUserRequest;
import com.hzqing.base.provider.dal.entity.Menu;
import com.hzqing.base.provider.dal.entity.Role;
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

    Menu req2Menu(DeleteMenuRequest request);

    MenuDto req2Dto(Menu menu);

    List<MenuDto> listMenu2ListDto(List<Menu> menus);

    Menu req2Menu(UpdateMenuRequest request);
}
