package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.menu.AddMenuRequest;
import com.hzqing.system.api.dto.menu.MenuDto;
import com.hzqing.system.api.dto.menu.MenuListRequest;
import com.hzqing.system.api.dto.menu.MenuPageRequest;
import com.hzqing.system.api.dto.menu.MenuTreeDto;
import com.hzqing.system.api.dto.menu.MenuTreeRequest;
import com.hzqing.system.api.dto.menu.UpdateMenuRequest;
import com.hzqing.system.provider.dal.entity.Menu;
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
public class MenuConverterImpl implements MenuConverter {

    @Override
    public Menu req2Menu(AddMenuRequest request) {
        if ( request == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setName( request.getName() );
        menu.setServeId( request.getServeId() );
        menu.setParentId( request.getParentId() );
        menu.setParentIds( request.getParentIds() );
        menu.setHref( request.getHref() );
        menu.setIcon( request.getIcon() );
        menu.setShowFlag( request.getShowFlag() );
        menu.setPermission( request.getPermission() );
        menu.setDelFlag( request.getDelFlag() );
        menu.setDescription( request.getDescription() );
        menu.setSort( request.getSort() );

        return menu;
    }

    @Override
    public Menu req2Menu(MenuListRequest request) {
        if ( request == null ) {
            return null;
        }

        Menu menu = new Menu();

        return menu;
    }

    @Override
    public MenuDto req2Dto(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuDto menuDto = new MenuDto();

        menuDto.setId( menu.getId() );
        menuDto.setName( menu.getName() );
        if ( menu.getServeId() != null ) {
            menuDto.setServeId( Integer.parseInt( menu.getServeId() ) );
        }
        menuDto.setParentId( menu.getParentId() );
        menuDto.setParentIds( menu.getParentIds() );
        menuDto.setHref( menu.getHref() );
        menuDto.setIcon( menu.getIcon() );
        menuDto.setShowFlag( menu.getShowFlag() );
        menuDto.setPermission( menu.getPermission() );
        menuDto.setDelFlag( menu.getDelFlag() );
        menuDto.setDescription( menu.getDescription() );
        menuDto.setSort( menu.getSort() );
        menuDto.setCreateBy( menu.getCreateBy() );
        menuDto.setCreateTime( menu.getCreateTime() );
        menuDto.setUpdateBy( menu.getUpdateBy() );
        menuDto.setUpdateTime( menu.getUpdateTime() );

        return menuDto;
    }

    @Override
    public List<MenuDto> listMenu2ListDto(List<Menu> menus) {
        if ( menus == null ) {
            return null;
        }

        List<MenuDto> list = new ArrayList<MenuDto>( menus.size() );
        for ( Menu menu : menus ) {
            list.add( req2Dto( menu ) );
        }

        return list;
    }

    @Override
    public Menu req2Menu(UpdateMenuRequest request) {
        if ( request == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setId( request.getId() );
        menu.setName( request.getName() );
        menu.setServeId( request.getServeId() );
        menu.setHref( request.getHref() );
        menu.setIcon( request.getIcon() );
        menu.setShowFlag( request.getShowFlag() );
        menu.setPermission( request.getPermission() );
        menu.setDescription( request.getDescription() );
        menu.setSort( request.getSort() );

        return menu;
    }

    @Override
    public Menu req2Menu(MenuPageRequest request) {
        if ( request == null ) {
            return null;
        }

        Menu menu = new Menu();

        return menu;
    }

    @Override
    public Page<MenuDto> pageMenu2PageDto(IPage<Menu> menuIPage) {
        if ( menuIPage == null ) {
            return null;
        }

        Page<MenuDto> page = new Page<MenuDto>();

        page.setPages( menuIPage.getPages() );
        page.setRecords( listMenu2ListDto( menuIPage.getRecords() ) );
        page.setTotal( menuIPage.getTotal() );
        page.setSize( menuIPage.getSize() );
        page.setCurrent( menuIPage.getCurrent() );
        page.setSearchCount( menuIPage.isSearchCount() );

        return page;
    }

    @Override
    public Menu req2Menu(MenuTreeRequest request) {
        if ( request == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setServeId( request.getServeId() );

        return menu;
    }

    @Override
    public List<MenuTreeDto> listMenu2ListTreeDto(List<Menu> menus) {
        if ( menus == null ) {
            return null;
        }

        List<MenuTreeDto> list = new ArrayList<MenuTreeDto>( menus.size() );
        for ( Menu menu : menus ) {
            list.add( menuToMenuTreeDto( menu ) );
        }

        return list;
    }

    protected MenuTreeDto menuToMenuTreeDto(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuTreeDto menuTreeDto = new MenuTreeDto();

        menuTreeDto.setId( menu.getId() );
        menuTreeDto.setParentId( menu.getParentId() );
        menuTreeDto.setName( menu.getName() );
        menuTreeDto.setParentIds( menu.getParentIds() );
        menuTreeDto.setServeId( menu.getServeId() );
        menuTreeDto.setHref( menu.getHref() );
        menuTreeDto.setIcon( menu.getIcon() );
        menuTreeDto.setShowFlag( menu.getShowFlag() );
        menuTreeDto.setPermission( menu.getPermission() );
        menuTreeDto.setDelFlag( menu.getDelFlag() );
        menuTreeDto.setDescription( menu.getDescription() );
        menuTreeDto.setSort( menu.getSort() );
        menuTreeDto.setCreateBy( menu.getCreateBy() );
        menuTreeDto.setCreateTime( menu.getCreateTime() );
        menuTreeDto.setUpdateBy( menu.getUpdateBy() );
        menuTreeDto.setUpdateTime( menu.getUpdateTime() );

        return menuTreeDto;
    }
}
