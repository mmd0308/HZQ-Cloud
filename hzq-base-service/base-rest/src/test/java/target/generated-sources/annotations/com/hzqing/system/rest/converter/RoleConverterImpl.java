package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.role.AddRoleRequest;
import com.hzqing.system.api.dto.role.AddRoleResourceRequest;
import com.hzqing.system.api.dto.role.RoleDto;
import com.hzqing.system.api.dto.role.RoleTreeDto;
import com.hzqing.system.api.dto.role.RoleTreeRequest;
import com.hzqing.system.api.dto.role.UpdateRoleRequest;
import com.hzqing.system.api.dto.role.UpdateRoleResourceRequest;
import com.hzqing.system.rest.vo.ResourceVo;
import com.hzqing.system.rest.vo.RoleTreeVO;
import com.hzqing.system.rest.vo.RoleVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-02T16:15:38+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class RoleConverterImpl implements RoleConverter {

    @Override
    public RoleVO dto2vo(RoleDto data) {
        if ( data == null ) {
            return null;
        }

        RoleVO roleVO = new RoleVO();

        roleVO.setId( data.getId() );
        roleVO.setParentId( data.getParentId() );
        roleVO.setParentIds( data.getParentIds() );
        roleVO.setName( data.getName() );
        roleVO.setRemarks( data.getRemarks() );
        roleVO.setDelFlag( data.getDelFlag() );
        roleVO.setSysFlag( data.getSysFlag() );
        roleVO.setCreateBy( data.getCreateBy() );
        roleVO.setCreateTime( data.getCreateTime() );
        roleVO.setUpdateBy( data.getUpdateBy() );
        roleVO.setUpdateTime( data.getUpdateTime() );

        return roleVO;
    }

    @Override
    public AddRoleRequest vo2Dto(RoleVO roleVO) {
        if ( roleVO == null ) {
            return null;
        }

        AddRoleRequest addRoleRequest = new AddRoleRequest();

        addRoleRequest.setId( roleVO.getId() );
        addRoleRequest.setParentId( roleVO.getParentId() );
        addRoleRequest.setParentIds( roleVO.getParentIds() );
        addRoleRequest.setName( roleVO.getName() );
        addRoleRequest.setRemarks( roleVO.getRemarks() );
        addRoleRequest.setDelFlag( roleVO.getDelFlag() );
        addRoleRequest.setSysFlag( roleVO.getSysFlag() );
        addRoleRequest.setCreateBy( roleVO.getCreateBy() );
        addRoleRequest.setCreateTime( roleVO.getCreateTime() );
        addRoleRequest.setUpdateBy( roleVO.getUpdateBy() );
        addRoleRequest.setUpdateTime( roleVO.getUpdateTime() );

        return addRoleRequest;
    }

    @Override
    public UpdateRoleRequest vo2UpdateDto(RoleVO roleVO) {
        if ( roleVO == null ) {
            return null;
        }

        UpdateRoleRequest updateRoleRequest = new UpdateRoleRequest();

        updateRoleRequest.setId( roleVO.getId() );
        updateRoleRequest.setName( roleVO.getName() );
        updateRoleRequest.setParentId( roleVO.getParentId() );
        updateRoleRequest.setParentIds( roleVO.getParentIds() );
        updateRoleRequest.setRemarks( roleVO.getRemarks() );
        updateRoleRequest.setSysFlag( roleVO.getSysFlag() );
        if ( roleVO.getUpdateBy() != null ) {
            updateRoleRequest.setUpdateBy( Integer.parseInt( roleVO.getUpdateBy() ) );
        }
        updateRoleRequest.setUpdateTime( roleVO.getUpdateTime() );

        return updateRoleRequest;
    }

    @Override
    public Page<RoleVO> dto2Vo(Page<RoleDto> data) {
        if ( data == null ) {
            return null;
        }

        Page<RoleVO> page = new Page<RoleVO>();

        page.setPages( data.getPages() );
        page.setRecords( roleDtoListToRoleVOList( data.getRecords() ) );
        page.setTotal( data.getTotal() );
        page.setSize( data.getSize() );
        page.setCurrent( data.getCurrent() );
        List<OrderItem> list1 = data.getOrders();
        if ( list1 != null ) {
            page.setOrders( new ArrayList<OrderItem>( list1 ) );
        }
        page.setSearchCount( data.isSearchCount() );

        return page;
    }

    @Override
    public RoleTreeRequest vo2TreeDto(RoleVO roleVO) {
        if ( roleVO == null ) {
            return null;
        }

        RoleTreeRequest roleTreeRequest = new RoleTreeRequest();

        return roleTreeRequest;
    }

    @Override
    public List<RoleTreeVO> dto2Treevo(List<RoleTreeDto> data) {
        if ( data == null ) {
            return null;
        }

        List<RoleTreeVO> list = new ArrayList<RoleTreeVO>( data.size() );
        for ( RoleTreeDto roleTreeDto : data ) {
            list.add( roleTreeDtoToRoleTreeVO( roleTreeDto ) );
        }

        return list;
    }

    @Override
    public AddRoleResourceRequest resourceVo2Dto(ResourceVo resourceVo) {
        if ( resourceVo == null ) {
            return null;
        }

        AddRoleResourceRequest addRoleResourceRequest = new AddRoleResourceRequest();

        addRoleResourceRequest.setRoleId( resourceVo.getRoleId() );
        addRoleResourceRequest.setServeId( resourceVo.getServeId() );
        addRoleResourceRequest.setMenuId( resourceVo.getMenuId() );
        addRoleResourceRequest.setElementId( resourceVo.getElementId() );

        return addRoleResourceRequest;
    }

    @Override
    public UpdateRoleResourceRequest resourceVo2UpdateDto(ResourceVo resourceVo) {
        if ( resourceVo == null ) {
            return null;
        }

        UpdateRoleResourceRequest updateRoleResourceRequest = new UpdateRoleResourceRequest();

        updateRoleResourceRequest.setRoleId( resourceVo.getRoleId() );
        updateRoleResourceRequest.setServeId( resourceVo.getServeId() );
        updateRoleResourceRequest.setMenuId( resourceVo.getMenuId() );
        updateRoleResourceRequest.setElementId( resourceVo.getElementId() );

        return updateRoleResourceRequest;
    }

    protected List<RoleVO> roleDtoListToRoleVOList(List<RoleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleVO> list1 = new ArrayList<RoleVO>( list.size() );
        for ( RoleDto roleDto : list ) {
            list1.add( dto2vo( roleDto ) );
        }

        return list1;
    }

    protected RoleTreeVO roleTreeDtoToRoleTreeVO(RoleTreeDto roleTreeDto) {
        if ( roleTreeDto == null ) {
            return null;
        }

        RoleTreeVO roleTreeVO = new RoleTreeVO();

        roleTreeVO.setId( roleTreeDto.getId() );
        roleTreeVO.setParentId( roleTreeDto.getParentId() );
        roleTreeVO.setParentIds( roleTreeDto.getParentIds() );
        roleTreeVO.setName( roleTreeDto.getName() );
        roleTreeVO.setRemarks( roleTreeDto.getRemarks() );
        roleTreeVO.setDelFlag( roleTreeDto.getDelFlag() );
        roleTreeVO.setSysFlag( roleTreeDto.getSysFlag() );
        roleTreeVO.setCreateBy( roleTreeDto.getCreateBy() );
        roleTreeVO.setCreateTime( roleTreeDto.getCreateTime() );
        roleTreeVO.setUpdateBy( roleTreeDto.getUpdateBy() );
        roleTreeVO.setUpdateTime( roleTreeDto.getUpdateTime() );
        roleTreeVO.setChildren( dto2Treevo( roleTreeDto.getChildren() ) );

        return roleTreeVO;
    }
}
