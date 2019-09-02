package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.provider.dal.entity.Role;
import com.hzqing.system.provider.dal.entity.RoleResource;
import com.hzqing.system.api.dto.role.*;
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

    RoleDto req2Dto(Role role);

    List<RoleDto> listRole2ListDto(List<Role> roles);

    Role req2Role(UpdateRoleRequest request);

    Role req2Role(RolePageRequest request);

    Page<RoleDto> pageRole2PageDto(IPage<Role> roleIPage);

    Role req2Role(RoleTreeRequest request);

    List<RoleTreeDto> listRole2ListTreeDto(List<Role> roles);

    List<RoleResourceDto> listRoleResource2Dto(List<RoleResource> resource);

    RoleResource reqRes2RoleResource(UpdateRoleResourceRequest request);
}
