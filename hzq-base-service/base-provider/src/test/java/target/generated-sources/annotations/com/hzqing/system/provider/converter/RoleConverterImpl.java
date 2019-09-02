package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.role.AddRoleRequest;
import com.hzqing.system.api.dto.role.RoleDto;
import com.hzqing.system.api.dto.role.RoleListRequest;
import com.hzqing.system.api.dto.role.RolePageRequest;
import com.hzqing.system.api.dto.role.RoleResourceDto;
import com.hzqing.system.api.dto.role.RoleTreeDto;
import com.hzqing.system.api.dto.role.RoleTreeRequest;
import com.hzqing.system.api.dto.role.UpdateRoleRequest;
import com.hzqing.system.api.dto.role.UpdateRoleResourceRequest;
import com.hzqing.system.provider.dal.entity.Role;
import com.hzqing.system.provider.dal.entity.RoleResource;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-02T15:45:24+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class RoleConverterImpl implements RoleConverter {

    @Override
    public Role req2Role(AddRoleRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( request.getId() );
        role.setName( request.getName() );
        role.setRemarks( request.getRemarks() );
        role.setDelFlag( request.getDelFlag() );
        role.setSysFlag( request.getSysFlag() );
        role.setCreateBy( request.getCreateBy() );
        role.setCreateTime( request.getCreateTime() );
        role.setUpdateBy( request.getUpdateBy() );
        role.setUpdateTime( request.getUpdateTime() );
        role.setParentId( request.getParentId() );
        role.setParentIds( request.getParentIds() );

        return role;
    }

    @Override
    public Role req2Role(RoleListRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        return role;
    }

    @Override
    public RoleDto req2Dto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );
        roleDto.setRemarks( role.getRemarks() );
        roleDto.setDelFlag( role.getDelFlag() );
        roleDto.setSysFlag( role.getSysFlag() );
        roleDto.setCreateBy( role.getCreateBy() );
        roleDto.setCreateTime( role.getCreateTime() );
        roleDto.setUpdateBy( role.getUpdateBy() );
        roleDto.setUpdateTime( role.getUpdateTime() );
        roleDto.setParentId( role.getParentId() );
        roleDto.setParentIds( role.getParentIds() );

        return roleDto;
    }

    @Override
    public List<RoleDto> listRole2ListDto(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roles.size() );
        for ( Role role : roles ) {
            list.add( req2Dto( role ) );
        }

        return list;
    }

    @Override
    public Role req2Role(UpdateRoleRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( request.getId() );
        role.setName( request.getName() );
        role.setRemarks( request.getRemarks() );
        role.setSysFlag( request.getSysFlag() );
        if ( request.getUpdateBy() != null ) {
            role.setUpdateBy( String.valueOf( request.getUpdateBy() ) );
        }
        role.setUpdateTime( request.getUpdateTime() );
        role.setParentId( request.getParentId() );
        role.setParentIds( request.getParentIds() );

        return role;
    }

    @Override
    public Role req2Role(RolePageRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        return role;
    }

    @Override
    public Page<RoleDto> pageRole2PageDto(IPage<Role> roleIPage) {
        if ( roleIPage == null ) {
            return null;
        }

        Page<RoleDto> page = new Page<RoleDto>();

        page.setPages( roleIPage.getPages() );
        page.setRecords( listRole2ListDto( roleIPage.getRecords() ) );
        page.setTotal( roleIPage.getTotal() );
        page.setSize( roleIPage.getSize() );
        page.setCurrent( roleIPage.getCurrent() );
        page.setSearchCount( roleIPage.isSearchCount() );

        return page;
    }

    @Override
    public Role req2Role(RoleTreeRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        return role;
    }

    @Override
    public List<RoleTreeDto> listRole2ListTreeDto(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleTreeDto> list = new ArrayList<RoleTreeDto>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToRoleTreeDto( role ) );
        }

        return list;
    }

    @Override
    public List<RoleResourceDto> listRoleResource2Dto(List<RoleResource> resource) {
        if ( resource == null ) {
            return null;
        }

        List<RoleResourceDto> list = new ArrayList<RoleResourceDto>( resource.size() );
        for ( RoleResource roleResource : resource ) {
            list.add( roleResourceToRoleResourceDto( roleResource ) );
        }

        return list;
    }

    @Override
    public RoleResource reqRes2RoleResource(UpdateRoleResourceRequest request) {
        if ( request == null ) {
            return null;
        }

        RoleResource roleResource = new RoleResource();

        roleResource.setRoleId( request.getRoleId() );
        roleResource.setServeId( request.getServeId() );
        roleResource.setMenuId( request.getMenuId() );
        roleResource.setElementId( request.getElementId() );

        return roleResource;
    }

    protected RoleTreeDto roleToRoleTreeDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleTreeDto roleTreeDto = new RoleTreeDto();

        roleTreeDto.setId( role.getId() );
        roleTreeDto.setParentId( role.getParentId() );
        roleTreeDto.setName( role.getName() );
        roleTreeDto.setRemarks( role.getRemarks() );
        roleTreeDto.setDelFlag( role.getDelFlag() );
        roleTreeDto.setSysFlag( role.getSysFlag() );
        roleTreeDto.setCreateBy( role.getCreateBy() );
        roleTreeDto.setCreateTime( role.getCreateTime() );
        roleTreeDto.setUpdateBy( role.getUpdateBy() );
        roleTreeDto.setUpdateTime( role.getUpdateTime() );
        roleTreeDto.setParentIds( role.getParentIds() );

        return roleTreeDto;
    }

    protected RoleResourceDto roleResourceToRoleResourceDto(RoleResource roleResource) {
        if ( roleResource == null ) {
            return null;
        }

        RoleResourceDto roleResourceDto = new RoleResourceDto();

        roleResourceDto.setRoleId( roleResource.getRoleId() );
        roleResourceDto.setServeId( roleResource.getServeId() );
        roleResourceDto.setMenuId( roleResource.getMenuId() );
        roleResourceDto.setElementId( roleResource.getElementId() );

        return roleResourceDto;
    }
}
