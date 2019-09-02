package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.button.AddElementRequest;
import com.hzqing.system.api.dto.button.ElementDto;
import com.hzqing.system.api.dto.button.ElementListRequest;
import com.hzqing.system.api.dto.button.UpdateElementRequest;
import com.hzqing.system.rest.vo.ElementVO;
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
public class ElementConverterImpl implements ElementConverter {

    @Override
    public ElementVO dto2vo(ElementDto data) {
        if ( data == null ) {
            return null;
        }

        ElementVO elementVO = new ElementVO();

        elementVO.setId( data.getId() );
        elementVO.setMenuId( data.getMenuId() );
        elementVO.setName( data.getName() );
        elementVO.setPermission( data.getPermission() );
        elementVO.setHref( data.getHref() );
        elementVO.setCreateBy( data.getCreateBy() );
        elementVO.setCeateTime( data.getCeateTime() );
        elementVO.setUpdateBy( data.getUpdateBy() );
        elementVO.setUpdateTime( data.getUpdateTime() );

        return elementVO;
    }

    @Override
    public Page<ElementVO> dto2Vo(Page<ElementDto> data) {
        if ( data == null ) {
            return null;
        }

        Page<ElementVO> page = new Page<ElementVO>();

        page.setPages( data.getPages() );
        page.setRecords( elementDtoListToElementVOList( data.getRecords() ) );
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
    public AddElementRequest vo2Dto(ElementVO buttonVO) {
        if ( buttonVO == null ) {
            return null;
        }

        AddElementRequest addElementRequest = new AddElementRequest();

        addElementRequest.setMenuId( buttonVO.getMenuId() );
        addElementRequest.setName( buttonVO.getName() );
        addElementRequest.setPermission( buttonVO.getPermission() );
        addElementRequest.setHref( buttonVO.getHref() );
        addElementRequest.setCreateBy( buttonVO.getCreateBy() );
        addElementRequest.setCeateTime( buttonVO.getCeateTime() );
        addElementRequest.setUpdateBy( buttonVO.getUpdateBy() );
        addElementRequest.setUpdateTime( buttonVO.getUpdateTime() );

        return addElementRequest;
    }

    @Override
    public UpdateElementRequest vo2UpdateDto(ElementVO buttonVO) {
        if ( buttonVO == null ) {
            return null;
        }

        UpdateElementRequest updateElementRequest = new UpdateElementRequest();

        updateElementRequest.setId( buttonVO.getId() );
        updateElementRequest.setMenuId( buttonVO.getMenuId() );
        updateElementRequest.setName( buttonVO.getName() );
        updateElementRequest.setPermission( buttonVO.getPermission() );
        updateElementRequest.setHref( buttonVO.getHref() );
        updateElementRequest.setCreateBy( buttonVO.getCreateBy() );
        updateElementRequest.setCeateTime( buttonVO.getCeateTime() );
        updateElementRequest.setUpdateBy( buttonVO.getUpdateBy() );
        updateElementRequest.setUpdateTime( buttonVO.getUpdateTime() );

        return updateElementRequest;
    }

    @Override
    public ElementListRequest vo2ListDto(ElementVO buttonVO) {
        if ( buttonVO == null ) {
            return null;
        }

        ElementListRequest elementListRequest = new ElementListRequest();

        elementListRequest.setMenuId( buttonVO.getMenuId() );

        return elementListRequest;
    }

    protected List<ElementVO> elementDtoListToElementVOList(List<ElementDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ElementVO> list1 = new ArrayList<ElementVO>( list.size() );
        for ( ElementDto elementDto : list ) {
            list1.add( dto2vo( elementDto ) );
        }

        return list1;
    }
}
