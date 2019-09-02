package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.menu.AddMenuRequest;
import com.hzqing.system.api.dto.menu.MenuDto;
import com.hzqing.system.api.dto.menu.MenuListRequest;
import com.hzqing.system.api.dto.menu.MenuTreeDto;
import com.hzqing.system.api.dto.menu.MenuTreeRequest;
import com.hzqing.system.api.dto.menu.UpdateMenuRequest;
import com.hzqing.system.rest.vo.MenuTreeVO;
import com.hzqing.system.rest.vo.MenuVO;
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
public class MenuConverterImpl implements MenuConverter {

    @Override
    public MenuVO dto2vo(MenuDto data) {
        if ( data == null ) {
            return null;
        }

        MenuVO menuVO = new MenuVO();

        menuVO.setId( data.getId() );
        menuVO.setName( data.getName() );
        if ( data.getServeId() != null ) {
            menuVO.setServeId( String.valueOf( data.getServeId() ) );
        }
        menuVO.setParentId( data.getParentId() );
        menuVO.setParentIds( data.getParentIds() );
        menuVO.setHref( data.getHref() );
        menuVO.setIcon( data.getIcon() );
        menuVO.setShowFlag( data.getShowFlag() );
        menuVO.setPermission( data.getPermission() );
        menuVO.setDelFlag( data.getDelFlag() );
        menuVO.setDescription( data.getDescription() );
        if ( data.getSort() != null ) {
            menuVO.setSort( data.getSort() );
        }
        menuVO.setCreateBy( data.getCreateBy() );
        menuVO.setCreateTime( data.getCreateTime() );
        menuVO.setUpdateBy( data.getUpdateBy() );
        menuVO.setUpdateTime( data.getUpdateTime() );

        return menuVO;
    }

    @Override
    public Page<MenuVO> pageDto2PageVo(Page<MenuDto> data) {
        if ( data == null ) {
            return null;
        }

        Page<MenuVO> page = new Page<MenuVO>();

        page.setPages( data.getPages() );
        page.setRecords( dto2vo( data.getRecords() ) );
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
    public UpdateMenuRequest vo2UpdateDto(MenuVO menuVO) {
        if ( menuVO == null ) {
            return null;
        }

        UpdateMenuRequest updateMenuRequest = new UpdateMenuRequest();

        updateMenuRequest.setId( menuVO.getId() );
        updateMenuRequest.setName( menuVO.getName() );
        updateMenuRequest.setServeId( menuVO.getServeId() );
        updateMenuRequest.setHref( menuVO.getHref() );
        updateMenuRequest.setIcon( menuVO.getIcon() );
        updateMenuRequest.setShowFlag( menuVO.getShowFlag() );
        updateMenuRequest.setPermission( menuVO.getPermission() );
        updateMenuRequest.setDescription( menuVO.getDescription() );
        updateMenuRequest.setSort( menuVO.getSort() );

        return updateMenuRequest;
    }

    @Override
    public AddMenuRequest vo2Dto(MenuVO menuVO) {
        if ( menuVO == null ) {
            return null;
        }

        AddMenuRequest addMenuRequest = new AddMenuRequest();

        addMenuRequest.setName( menuVO.getName() );
        addMenuRequest.setServeId( menuVO.getServeId() );
        addMenuRequest.setParentId( menuVO.getParentId() );
        addMenuRequest.setParentIds( menuVO.getParentIds() );
        addMenuRequest.setHref( menuVO.getHref() );
        addMenuRequest.setIcon( menuVO.getIcon() );
        addMenuRequest.setShowFlag( menuVO.getShowFlag() );
        addMenuRequest.setPermission( menuVO.getPermission() );
        addMenuRequest.setDelFlag( menuVO.getDelFlag() );
        addMenuRequest.setDescription( menuVO.getDescription() );
        addMenuRequest.setSort( menuVO.getSort() );

        return addMenuRequest;
    }

    @Override
    public MenuListRequest vo2ListDto(MenuVO menuVO) {
        if ( menuVO == null ) {
            return null;
        }

        MenuListRequest menuListRequest = new MenuListRequest();

        return menuListRequest;
    }

    @Override
    public List<MenuVO> dto2vo(List<MenuDto> data) {
        if ( data == null ) {
            return null;
        }

        List<MenuVO> list = new ArrayList<MenuVO>( data.size() );
        for ( MenuDto menuDto : data ) {
            list.add( dto2vo( menuDto ) );
        }

        return list;
    }

    @Override
    public MenuTreeRequest vo2TreeDto(MenuVO menuVO) {
        if ( menuVO == null ) {
            return null;
        }

        MenuTreeRequest menuTreeRequest = new MenuTreeRequest();

        menuTreeRequest.setServeId( menuVO.getServeId() );

        return menuTreeRequest;
    }

    @Override
    public List<MenuTreeVO> dto2Treevo(List<MenuTreeDto> data) {
        if ( data == null ) {
            return null;
        }

        List<MenuTreeVO> list = new ArrayList<MenuTreeVO>( data.size() );
        for ( MenuTreeDto menuTreeDto : data ) {
            list.add( menuTreeDtoToMenuTreeVO( menuTreeDto ) );
        }

        return list;
    }

    protected MenuTreeVO menuTreeDtoToMenuTreeVO(MenuTreeDto menuTreeDto) {
        if ( menuTreeDto == null ) {
            return null;
        }

        MenuTreeVO menuTreeVO = new MenuTreeVO();

        menuTreeVO.setId( menuTreeDto.getId() );
        menuTreeVO.setName( menuTreeDto.getName() );
        menuTreeVO.setServeId( menuTreeDto.getServeId() );
        menuTreeVO.setParentId( menuTreeDto.getParentId() );
        menuTreeVO.setParentIds( menuTreeDto.getParentIds() );
        menuTreeVO.setHref( menuTreeDto.getHref() );
        menuTreeVO.setIcon( menuTreeDto.getIcon() );
        menuTreeVO.setShowFlag( menuTreeDto.getShowFlag() );
        menuTreeVO.setPermission( menuTreeDto.getPermission() );
        menuTreeVO.setDelFlag( menuTreeDto.getDelFlag() );
        menuTreeVO.setDescription( menuTreeDto.getDescription() );
        if ( menuTreeDto.getSort() != null ) {
            menuTreeVO.setSort( menuTreeDto.getSort() );
        }
        menuTreeVO.setCreateBy( menuTreeDto.getCreateBy() );
        menuTreeVO.setCreateTime( menuTreeDto.getCreateTime() );
        menuTreeVO.setUpdateBy( menuTreeDto.getUpdateBy() );
        menuTreeVO.setUpdateTime( menuTreeDto.getUpdateTime() );
        menuTreeVO.setChildren( dto2Treevo( menuTreeDto.getChildren() ) );

        return menuTreeVO;
    }
}
