package com.hzqing.base.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.role.AddRoleRequest;
import com.hzqing.base.api.dto.role.RoleDto;
import com.hzqing.base.api.dto.role.UpdateRoleRequest;
import com.hzqing.base.rest.vo.RoleVO;
import org.mapstruct.Mapper;

/**
 * @author hzqing
 * @date 2019-08-12 22:07
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    RoleVO dto2vo(RoleDto data);

    AddRoleRequest vo2Dto(RoleVO roleVO);

    UpdateRoleRequest vo2UpdateDto(RoleVO roleVO);

    Page<RoleVO> dto2Vo(Page<RoleDto> data);
}
