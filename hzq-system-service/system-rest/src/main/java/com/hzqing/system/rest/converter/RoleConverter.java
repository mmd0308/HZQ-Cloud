package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.rest.vo.ResourceVo;
import com.hzqing.system.rest.vo.RoleTreeVO;
import com.hzqing.system.rest.vo.RoleVO;
import com.hzqing.system.api.dto.role.*;
import org.mapstruct.Mapper;

import java.util.List;

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

    RoleTreeRequest vo2TreeDto(RoleVO roleVO);

    List<RoleTreeVO> dto2Treevo(List<RoleTreeDto> data);

    AddRoleResourceRequest resourceVo2Dto(ResourceVo resourceVo);

    UpdateRoleResourceRequest resourceVo2UpdateDto(ResourceVo resourceVo);
}
