package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.role.*;
import com.hzqing.base.api.service.IRoleService;
import com.hzqing.base.provider.converter.RoleConverter;
import com.hzqing.base.provider.dal.entity.Role;
import com.hzqing.base.provider.dal.mapper.RoleMapper;
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
 * 角色管理表
 服务实现类
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V1)
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConverter roleConverter;


    @Override
    public CommonResponse save(AddRoleRequest request) {
        log.info("RoleServiceImpl.createRole request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Role role = roleConverter.req2Role(request);
            int row = roleMapper.insert(role);
            log.info("RoleServiceImpl.createRole effect row: " + row);
        }catch (Exception e){
            log.error("RoleServiceImpl.createRole occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<RoleDto> getById(IDRequest request) {
        log.info("RoleServiceImpl.roleDetail request: " + request);
        CommonResponse<RoleDto> response = new CommonResponse<>();
        try {
            request.checkParams();
            Role role = roleMapper.selectById(request.getId());
            RoleDto roleDto = roleConverter.req2Dto(role);
            response.setData(roleDto);
        }catch (Exception e){
            log.error("RoleServiceImpl.roleDetail occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<RoleDto>> list(RoleListRequest request) {
        CommonResponse<List<RoleDto>> response = new CommonResponse<>();
        log.info("RoleServiceImpl.roleLists request: " + request);
        try {
            request.checkParams();
            Role role = roleConverter.req2Role(request);
            List<Role> roles = roleMapper.selectList(new QueryWrapper<>(role));
            response.setData(roleConverter.listRole2ListDto(roles));
        }catch (Exception e){
            log.error("RoleServiceImpl.roleLists occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse removeById(IDRequest request) {
        log.info("RoleServiceImpl.deleteRole request: " + request);
        CommonResponse response = new CommonResponse();
        try{
            request.checkParams();
            int row = roleMapper.deleteById(request.getId());
            log.info("RoleServiceImpl.deleteRole effect row: " + row);
        }catch (Exception e){
            log.error("RoleServiceImpl.deleteRole occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse updateById(UpdateRoleRequest request) {
        log.info("RoleServiceImpl.updateRole request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            Role role = roleConverter.req2Role(request);
            int row = roleMapper.updateById(role);
            log.info("RoleServiceImpl.updateRole effect row: " + row);
        } catch (Exception e){
            log.error("RoleServiceImpl.updateRole occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Page<RoleDto>> page(RolePageRequest request) {
        log.info("RoleServiceImpl.rolePage request: " + request);
        CommonResponse<Page<RoleDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Role role = roleConverter.req2Role(request);
            IPage<Role> roleIPage = roleMapper.selectPage(
                    new Page<Role>(request.getPageNum(), request.getPageSize()),
                    new QueryWrapper<>(role));
            response.setData(roleConverter.pageRole2PageDto(roleIPage));
        }catch (Exception e) {
            log.error("RoleServiceImpl.rolePage occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
