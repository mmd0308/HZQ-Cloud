package com.hzqing.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.request.PermissionRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.system.api.dto.button.*;
import com.hzqing.system.api.service.IElementService;
import com.hzqing.system.provider.converter.ElementConverter;
import com.hzqing.system.provider.dal.entity.Element;
import com.hzqing.system.provider.dal.mapper.ElementMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
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
    private ElementMapper elementMapper;

    @Autowired
    private ElementConverter elementConverter;


    @Override
    public CommonResponse save(AddElementRequest request) {
        log.info("ElementServiceImpl.createButton request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Element button = elementConverter.req2Button(request);
            button.setCreateTime(LocalDateTime.now());
            button.setUpdateTime(LocalDateTime.now());
            int row = elementMapper.insert(button);
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
            Element button = elementMapper.selectById(request.getId());
            ElementDto buttonDto = elementConverter.req2Dto(button);
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
            Element button = elementConverter.req2Button(request);
            List<Element> buttons = elementMapper.selectList(new QueryWrapper<>(button));
            response.setData(elementConverter.listButton2ListDto(buttons));
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
            int row = elementMapper.deleteById(request.getId());
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
            Element button = elementConverter.req2Button(request);
            button.setUpdateTime(LocalDateTime.now());
            int row = elementMapper.updateById(button);
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
            Element button = elementConverter.req2Button(request);
            IPage<Element> buttonIPage = elementMapper.selectPage(
                    new Page<Element>(request.getPageNum(), request.getPageSize()),
                    new QueryWrapper<>(button));
            response.setData(elementConverter.pageButton2PageDto(buttonIPage));
        }catch (Exception e) {
            log.error("ElementServiceImpl.buttonPage occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Boolean> checkPermission(PermissionRequest request) {
        log.info("ElementServiceImpl.checkPermission request: " + request);
        CommonResponse<Boolean> response = new CommonResponse<>();
        boolean res = false;
        try {
            request.checkParams();
            Element element = new Element();
            element.setPermission(request.getPermission());
            List<Element> elements = elementMapper.selectList(new QueryWrapper<>(element));
            log.info("ElementServiceImpl.checkPermission 查询结果集：" + elements);
            res = elements.size() == 0;
            if (elements.size() == 1) {
                Element ser = elements.get(0);
                if (StringUtils.isNotEmpty(request.getId())) {
                    // 表示修改，权限编码是自己
                    res = ser.getId().equals(request.getId());
                }
            }
            response.setData(res);
        } catch (Exception e) {
            log.error("ElementServiceImpl.checkPermission occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
