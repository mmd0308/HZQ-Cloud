package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.serve.*;
import com.hzqing.base.api.service.IServeService;
import com.hzqing.base.provider.converter.ServeConverter;
import com.hzqing.base.provider.dal.entity.Serve;
import com.hzqing.base.provider.dal.mapper.ServeMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 服务管理表
 * 服务实现类
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V1)
public class ServeServiceImpl implements IServeService {

    @Autowired
    private ServeMapper serveMapper;

    @Autowired
    private ServeConverter serveConverter;


    @Override
    public CommonResponse createServe(AddServeRequest request) {
        log.info("ServeServiceImpl.createServe request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Serve serve = serveConverter.req2Serve(request);
            int row = serveMapper.insert(serve);
            log.info("ServeServiceImpl.createServe effect row: " + row);
        }catch (Exception e){
            log.error("ServeServiceImpl.createServe occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<ServeDto> serveDetail(ServeDetailRequest request) {
        log.info("ServeServiceImpl.serveDetail request: " + request);
        CommonResponse<ServeDto> response = new CommonResponse<>();
        try {
            request.checkParams();
            Serve serve = serveMapper.selectById(request.getId());
            ServeDto serveDto = serveConverter.req2Dto(serve);
            response.setData(serveDto);
        }catch (Exception e){
            log.error("ServeServiceImpl.serveDetail occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<ServeDto>> serveLists(ServeListRequest request) {
        CommonResponse<List<ServeDto>> response = new CommonResponse<>();
        log.info("ServeServiceImpl.serveLists request: " + request);
        try {
            request.checkParams();
            Serve serve = serveConverter.req2Serve(request);
            List<Serve> serves = serveMapper.selectList(new QueryWrapper<>(serve));
            response.setData(serveConverter.listServe2ListDto(serves));
        }catch (Exception e){
            log.error("ServeServiceImpl.serveLists occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse deleteServe(DeleteServeRequest request) {
        log.info("ServeServiceImpl.deleteServe request: " + request);
        CommonResponse response = new CommonResponse();
        try{
            request.checkParams();
            int row = serveMapper.deleteById(request.getId());
            log.info("ServeServiceImpl.deleteServe effect row: " + row);
        }catch (Exception e){
            log.error("ServeServiceImpl.deleteServe occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse updateServe(UpdateServeRequest request) {
        log.info("ServeServiceImpl.updateServe request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Serve serve = serveConverter.req2Serve(request);
            int row = serveMapper.updateById(serve);
            log.info("ServeServiceImpl.updateServe effect row: " + row);
        } catch (Exception e){
            log.error("ServeServiceImpl.updateServe occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Page<ServeDto>> servePage(ServePageRequest request) {
        log.info("ServeServiceImpl.servePage request: " + request);
        CommonResponse<Page<ServeDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Serve serve = serveConverter.req2Serve(request);
            IPage<Serve> serveIPage = serveMapper.selectPage(
                    new Page<Serve>(request.getPageNum(), request.getPageSize()),
                    new QueryWrapper<>(serve));
            response.setData(serveConverter.pageServe2PageDto(serveIPage));
        }catch (Exception e) {
            log.error("ServeServiceImpl.servePage occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
