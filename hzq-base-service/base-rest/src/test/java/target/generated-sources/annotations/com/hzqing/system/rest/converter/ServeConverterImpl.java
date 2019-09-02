package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.serve.AddServeRequest;
import com.hzqing.system.api.dto.serve.ServeDto;
import com.hzqing.system.api.dto.serve.ServeListRequest;
import com.hzqing.system.api.dto.serve.UpdateServeRequest;
import com.hzqing.system.rest.vo.ServeVO;
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
public class ServeConverterImpl implements ServeConverter {

    @Override
    public ServeVO dto2vo(ServeDto data) {
        if ( data == null ) {
            return null;
        }

        ServeVO serveVO = new ServeVO();

        serveVO.setId( data.getId() );
        serveVO.setName( data.getName() );
        serveVO.setStatus( data.getStatus() );
        serveVO.setPermission( data.getPermission() );
        serveVO.setCreateBy( data.getCreateBy() );
        serveVO.setCreateTime( data.getCreateTime() );
        serveVO.setUpdateBy( data.getUpdateBy() );
        serveVO.setUpdateTime( data.getUpdateTime() );

        return serveVO;
    }

    @Override
    public Page<ServeVO> dto2Vo(Page<ServeDto> data) {
        if ( data == null ) {
            return null;
        }

        Page<ServeVO> page = new Page<ServeVO>();

        page.setPages( data.getPages() );
        page.setRecords( dto2Vo( data.getRecords() ) );
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
    public AddServeRequest vo2Dto(ServeVO serveVO) {
        if ( serveVO == null ) {
            return null;
        }

        AddServeRequest addServeRequest = new AddServeRequest();

        addServeRequest.setName( serveVO.getName() );
        addServeRequest.setStatus( serveVO.getStatus() );
        addServeRequest.setPermission( serveVO.getPermission() );
        addServeRequest.setCreateBy( serveVO.getCreateBy() );
        addServeRequest.setCreateTime( serveVO.getCreateTime() );

        return addServeRequest;
    }

    @Override
    public UpdateServeRequest vo2UpdateDto(ServeVO serveVO) {
        if ( serveVO == null ) {
            return null;
        }

        UpdateServeRequest updateServeRequest = new UpdateServeRequest();

        updateServeRequest.setId( serveVO.getId() );
        updateServeRequest.setName( serveVO.getName() );
        updateServeRequest.setStatus( serveVO.getStatus() );
        updateServeRequest.setPermission( serveVO.getPermission() );
        updateServeRequest.setUpdateBy( serveVO.getUpdateBy() );
        updateServeRequest.setUpdateTime( serveVO.getUpdateTime() );

        return updateServeRequest;
    }

    @Override
    public ServeListRequest vo2ListDto(ServeVO serveVO) {
        if ( serveVO == null ) {
            return null;
        }

        ServeListRequest serveListRequest = new ServeListRequest();

        return serveListRequest;
    }

    @Override
    public List<ServeVO> dto2Vo(List<ServeDto> data) {
        if ( data == null ) {
            return null;
        }

        List<ServeVO> list = new ArrayList<ServeVO>( data.size() );
        for ( ServeDto serveDto : data ) {
            list.add( dto2vo( serveDto ) );
        }

        return list;
    }
}
