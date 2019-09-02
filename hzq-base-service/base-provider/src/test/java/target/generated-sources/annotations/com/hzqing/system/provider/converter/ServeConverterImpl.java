package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.serve.AddServeRequest;
import com.hzqing.system.api.dto.serve.ServeDto;
import com.hzqing.system.api.dto.serve.ServeListRequest;
import com.hzqing.system.api.dto.serve.ServePageRequest;
import com.hzqing.system.api.dto.serve.UpdateServeRequest;
import com.hzqing.system.provider.dal.entity.Serve;
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
public class ServeConverterImpl implements ServeConverter {

    @Override
    public Serve req2Serve(AddServeRequest request) {
        if ( request == null ) {
            return null;
        }

        Serve serve = new Serve();

        serve.setName( request.getName() );
        serve.setStatus( request.getStatus() );
        serve.setPermission( request.getPermission() );
        serve.setCreateBy( request.getCreateBy() );
        serve.setCreateTime( request.getCreateTime() );

        return serve;
    }

    @Override
    public ServeDto req2Dto(Serve serve) {
        if ( serve == null ) {
            return null;
        }

        ServeDto serveDto = new ServeDto();

        serveDto.setId( serve.getId() );
        serveDto.setName( serve.getName() );
        serveDto.setStatus( serve.getStatus() );
        serveDto.setPermission( serve.getPermission() );
        serveDto.setCreateBy( serve.getCreateBy() );
        serveDto.setCreateTime( serve.getCreateTime() );
        serveDto.setUpdateBy( serve.getUpdateBy() );
        serveDto.setUpdateTime( serve.getUpdateTime() );

        return serveDto;
    }

    @Override
    public Serve req2Serve(ServeListRequest request) {
        if ( request == null ) {
            return null;
        }

        Serve serve = new Serve();

        return serve;
    }

    @Override
    public List<ServeDto> listServe2ListDto(List<Serve> serves) {
        if ( serves == null ) {
            return null;
        }

        List<ServeDto> list = new ArrayList<ServeDto>( serves.size() );
        for ( Serve serve : serves ) {
            list.add( req2Dto( serve ) );
        }

        return list;
    }

    @Override
    public Serve req2Serve(ServePageRequest request) {
        if ( request == null ) {
            return null;
        }

        Serve serve = new Serve();

        return serve;
    }

    @Override
    public Page<ServeDto> pageServe2PageDto(IPage<Serve> serveIPage) {
        if ( serveIPage == null ) {
            return null;
        }

        Page<ServeDto> page = new Page<ServeDto>();

        page.setPages( serveIPage.getPages() );
        page.setRecords( listServe2ListDto( serveIPage.getRecords() ) );
        page.setTotal( serveIPage.getTotal() );
        page.setSize( serveIPage.getSize() );
        page.setCurrent( serveIPage.getCurrent() );
        page.setSearchCount( serveIPage.isSearchCount() );

        return page;
    }

    @Override
    public Serve req2Serve(UpdateServeRequest request) {
        if ( request == null ) {
            return null;
        }

        Serve serve = new Serve();

        serve.setId( request.getId() );
        serve.setName( request.getName() );
        serve.setStatus( request.getStatus() );
        serve.setPermission( request.getPermission() );
        serve.setUpdateBy( request.getUpdateBy() );
        serve.setUpdateTime( request.getUpdateTime() );

        return serve;
    }
}
