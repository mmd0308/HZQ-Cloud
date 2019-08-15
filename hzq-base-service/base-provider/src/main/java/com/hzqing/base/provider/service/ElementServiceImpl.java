package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.*;
import com.hzqing.base.api.service.IElementService;
import com.hzqing.base.provider.converter.ElementConverter;
import com.hzqing.base.provider.dal.entity.Element;
import com.hzqing.base.provider.dal.mapper.ElementMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 按钮资源管理表
 * 服务实现类
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-13
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V1)
public class ElementServiceImpl implements IElementService {

    @Autowired
    private ElementMapper buttonMapper;

    @Autowired
    private ElementConverter buttonConverter;


    @Override
    public CommonResponse save(AddElementRequest request) {
        log.info("ElementServiceImpl.createButton request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Element button = buttonConverter.req2Button(request);
            int row = buttonMapper.insert(button);
            log.info("ElementServiceImpl.createButton effect row: " + row);
        }catch (Exception e){
            log.error("ElementServiceImpl.createButton occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<ElementDto> getById(IDRequest request) {
        log.info("ElementServiceImpl.buttonDetail request: " + request);
        CommonResponse<ElementDto> response = new CommonResponse<>();
        try {
            request.checkParams();
            Element button = buttonMapper.selectById(request.getId());
            ElementDto buttonDto = buttonConverter.req2Dto(button);
            response.setData(buttonDto);
        }catch (Exception e){
            log.error("ElementServiceImpl.buttonDetail occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<ElementDto>> list(ElementListRequest request) {
        CommonResponse<List<ElementDto>> response = new CommonResponse<>();
        log.info("ElementServiceImpl.buttonLists request: " + request);
        try {
            request.checkParams();
            Element button = buttonConverter.req2Button(request);
            List<Element> buttons = buttonMapper.selectList(new QueryWrapper<>(button));
            response.setData(buttonConverter.listButton2ListDto(buttons));
        }catch (Exception e){
            log.error("ElementServiceImpl.buttonLists occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse removeById(IDRequest request) {
        log.info("ElementServiceImpl.deleteButton request: " + request);
        CommonResponse response = new CommonResponse();
        try{
            request.checkParams();
            int row = buttonMapper.deleteById(request.getId());
            log.info("ElementServiceImpl.deleteButton effect row: " + row);
        }catch (Exception e){
            log.error("ElementServiceImpl.deleteButton occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse updateById(UpdateElementRequest request) {
        log.info("ElementServiceImpl.updateButton request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            Element button = buttonConverter.req2Button(request);
            int row = buttonMapper.updateById(button);
            log.info("ElementServiceImpl.updateButton effect row: " + row);
        } catch (Exception e){
            log.error("ElementServiceImpl.updateButton occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Page<ElementDto>> page(ElementPageRequest request) {
        log.info("ElementServiceImpl.buttonPage request: " + request);
        CommonResponse<Page<ElementDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Element button = buttonConverter.req2Button(request);
            IPage<Element> buttonIPage = buttonMapper.selectPage(
                    new Page<Element>(request.getPageNum(), request.getPageSize()),
                    new QueryWrapper<>(button));
            response.setData(buttonConverter.pageButton2PageDto(buttonIPage));
        }catch (Exception e) {
            log.error("ElementServiceImpl.buttonPage occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
