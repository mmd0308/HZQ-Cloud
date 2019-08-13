package com.hzqing.base.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.role.*;
import com.hzqing.base.api.dto.user.DeleteUserRequest;
import com.hzqing.base.provider.dal.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    Role req2Role(AddRoleRequest request);

    Role req2Role(RoleListRequest request);

    Role req2Role(DeleteUserRequest request);

    RoleDto req2Dto(Role role);

    List<RoleDto> listRole2ListDto(List<Role> roles);

    Role req2Role(UpdateRoleRequest request);

    Role req2Role(RolePageRequest request);

    Page<RoleDto> pageRole2PageDto(IPage<Role> roleIPage);
}
