package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.button.AddElementRequest;
import com.hzqing.system.api.dto.button.ElementDto;
import com.hzqing.system.api.dto.button.ElementListRequest;
import com.hzqing.system.api.dto.button.ElementPageRequest;
import com.hzqing.system.api.dto.button.UpdateElementRequest;
import com.hzqing.system.provider.dal.entity.Element;
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
public class ElementConverterImpl implements ElementConverter {

    @Override
    public Element req2Button(AddElementRequest request) {
        if ( request == null ) {
            return null;
        }

        Element element = new Element();

        element.setMenuId( request.getMenuId() );
        element.setName( request.getName() );
        element.setPermission( request.getPermission() );
        element.setHref( request.getHref() );
        element.setCreateBy( request.getCreateBy() );
        element.setUpdateBy( request.getUpdateBy() );
        element.setUpdateTime( request.getUpdateTime() );
        element.setElementType( request.getElementType() );
        element.setMethod( request.getMethod() );
        element.setDescription( request.getDescription() );

        return element;
    }

    @Override
    public ElementDto req2Dto(Element button) {
        if ( button == null ) {
            return null;
        }

        ElementDto elementDto = new ElementDto();

        elementDto.setId( button.getId() );
        elementDto.setMenuId( button.getMenuId() );
        elementDto.setName( button.getName() );
        elementDto.setPermission( button.getPermission() );
        elementDto.setHref( button.getHref() );
        elementDto.setCreateBy( button.getCreateBy() );
        elementDto.setUpdateBy( button.getUpdateBy() );
        elementDto.setUpdateTime( button.getUpdateTime() );
        elementDto.setElementType( button.getElementType() );
        elementDto.setMethod( button.getMethod() );
        elementDto.setDescription( button.getDescription() );

        return elementDto;
    }

    @Override
    public List<ElementDto> listButton2ListDto(List<Element> buttons) {
        if ( buttons == null ) {
            return null;
        }

        List<ElementDto> list = new ArrayList<ElementDto>( buttons.size() );
        for ( Element element : buttons ) {
            list.add( req2Dto( element ) );
        }

        return list;
    }

    @Override
    public Element req2Button(UpdateElementRequest request) {
        if ( request == null ) {
            return null;
        }

        Element element = new Element();

        element.setId( request.getId() );
        element.setMenuId( request.getMenuId() );
        element.setName( request.getName() );
        element.setPermission( request.getPermission() );
        element.setHref( request.getHref() );
        element.setCreateBy( request.getCreateBy() );
        element.setUpdateBy( request.getUpdateBy() );
        element.setUpdateTime( request.getUpdateTime() );
        element.setElementType( request.getElementType() );
        element.setMethod( request.getMethod() );
        element.setDescription( request.getDescription() );

        return element;
    }

    @Override
    public Page<ElementDto> pageButton2PageDto(IPage<Element> buttonIPage) {
        if ( buttonIPage == null ) {
            return null;
        }

        Page<ElementDto> page = new Page<ElementDto>();

        page.setPages( buttonIPage.getPages() );
        page.setRecords( listButton2ListDto( buttonIPage.getRecords() ) );
        page.setTotal( buttonIPage.getTotal() );
        page.setSize( buttonIPage.getSize() );
        page.setCurrent( buttonIPage.getCurrent() );
        page.setSearchCount( buttonIPage.isSearchCount() );

        return page;
    }

    @Override
    public Element req2Button(ElementPageRequest request) {
        if ( request == null ) {
            return null;
        }

        Element element = new Element();

        element.setMenuId( request.getMenuId() );

        return element;
    }

    @Override
    public Element req2Button(ElementListRequest request) {
        if ( request == null ) {
            return null;
        }

        Element element = new Element();

        element.setMenuId( request.getMenuId() );

        return element;
    }
}
