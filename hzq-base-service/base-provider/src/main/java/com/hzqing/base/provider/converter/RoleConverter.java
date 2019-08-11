package com.hzqing.base.provider.converter;

import com.hzqing.base.api.dto.role.AddRoleRequest;
import com.hzqing.base.api.dto.role.RoleDto;
import com.hzqing.base.api.dto.role.RoleListRequest;
import com.hzqing.base.api.dto.user.AddUserRequest;
import com.hzqing.base.api.dto.user.DeleteUserRequest;
import com.hzqing.base.api.dto.user.UserDto;
import com.hzqing.base.api.dto.user.UserListRequest;
import com.hzqing.base.provider.dal.entity.Role;
import com.hzqing.base.provider.dal.entity.User;
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
}
