package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.*;
import com.hzqing.base.api.service.IButtonService;
import com.hzqing.base.provider.converter.ButtonConverter;
import com.hzqing.base.provider.dal.entity.Button;
import com.hzqing.base.provider.dal.mapper.ButtonMapper;
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
public class ButtonServiceImpl implements IButtonService {

    @Autowired
    private ButtonMapper buttonMapper;

    @Autowired
    private ButtonConverter buttonConverter;


    @Override
    public CommonResponse save(AddButtonRequest request) {
        log.info("ButtonServiceImpl.createButton request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Button button = buttonConverter.req2Button(request);
            int row = buttonMapper.insert(button);
            log.info("ButtonServiceImpl.createButton effect row: " + row);
        }catch (Exception e){
            log.error("ButtonServiceImpl.createButton occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<ButtonDto> getById(IDRequest request) {
        log.info("ButtonServiceImpl.buttonDetail request: " + request);
        CommonResponse<ButtonDto> response = new CommonResponse<>();
        try {
            request.checkParams();
            Button button = buttonMapper.selectById(request.getId());
            ButtonDto buttonDto = buttonConverter.req2Dto(button);
            response.setData(buttonDto);
        }catch (Exception e){
            log.error("ButtonServiceImpl.buttonDetail occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<ButtonDto>> list(ButtonListRequest request) {
        CommonResponse<List<ButtonDto>> response = new CommonResponse<>();
        log.info("ButtonServiceImpl.buttonLists request: " + request);
        try {
            request.checkParams();
            Button button = buttonConverter.req2Button(request);
            List<Button> buttons = buttonMapper.selectList(new QueryWrapper<>(button));
            response.setData(buttonConverter.listButton2ListDto(buttons));
        }catch (Exception e){
            log.error("ButtonServiceImpl.buttonLists occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse removeById(IDRequest request) {
        log.info("ButtonServiceImpl.deleteButton request: " + request);
        CommonResponse response = new CommonResponse();
        try{
            request.checkParams();
            int row = buttonMapper.deleteById(request.getId());
            log.info("ButtonServiceImpl.deleteButton effect row: " + row);
        }catch (Exception e){
            log.error("ButtonServiceImpl.deleteButton occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse updateById(UpdateButtonRequest request) {
        log.info("ButtonServiceImpl.updateButton request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            Button button = buttonConverter.req2Button(request);
            int row = buttonMapper.updateById(button);
            log.info("ButtonServiceImpl.updateButton effect row: " + row);
        } catch (Exception e){
            log.error("ButtonServiceImpl.updateButton occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Page<ButtonDto>> page(ButtonPageRequest request) {
        log.info("ButtonServiceImpl.buttonPage request: " + request);
        CommonResponse<Page<ButtonDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Button button = buttonConverter.req2Button(request);
            IPage<Button> buttonIPage = buttonMapper.selectPage(
                    new Page<Button>(request.getPageNum(), request.getPageSize()),
                    new QueryWrapper<>(button));
            response.setData(buttonConverter.pageButton2PageDto(buttonIPage));
        }catch (Exception e) {
            log.error("ButtonServiceImpl.buttonPage occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
