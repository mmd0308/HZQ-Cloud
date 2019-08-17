package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.role.*;
import com.hzqing.base.api.service.IRoleService;
import com.hzqing.base.provider.converter.RoleConverter;
import com.hzqing.base.provider.dal.entity.Role;
import com.hzqing.base.provider.dal.entity.RoleResource;
import com.hzqing.base.provider.dal.mapper.RoleMapper;
import com.hzqing.base.provider.dal.mapper.RoleResourceMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.common.tools.tree.TreeUtils;
import com.hzqing.common.tools.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

    private final static String PARENT_ID = "0";

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConverter roleConverter;

    @Autowired
    private RoleResourceMapper roleResourceMapper;


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

    @Override
    public CommonResponse<List<RoleTreeDto>> tree(RoleTreeRequest request) {
        log.info("RoleServiceImpl.tree request: " + request);
        CommonResponse<List<RoleTreeDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Role role = roleConverter.req2Role(request);
            List<Role> roles = roleMapper.selectList(new QueryWrapper<>(role));
            List<RoleTreeDto> listDtos = roleConverter.listRole2ListTreeDto(roles);
            log.info("RoleServiceImpl.tree 组装属性结果，查询数据数量是： " + listDtos.size());
            List<RoleTreeDto> treeDtos = TreeUtils.buildTree(PARENT_ID, listDtos);
            response.setData(treeDtos);
        } catch (Exception e) {
            log.error("RoleServiceImpl.tree occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse saveResource(AddRoleResourceRequest request) {
        log.info("RoleServiceImpl.saveResource request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            RoleResource resources = new RoleResource(
                    request.getRoleId(),
                    request.getServeId(),
                    request.getMenuId(),
                    request.getElementId()
            );

            log.info("RoleServiceImpl.saveResource 角色和资源授权" + resources);
            int row = roleResourceMapper.insert(resources);
            log.info("RoleServiceImpl.saveResource effect row: " + row);
        }catch (Exception e) {
            log.error("RoleServiceImpl.saveResource occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<RoleResourceDto>> listResource(IDRequest request) {
        log.info("RoleServiceImpl.listResource request: "  + request);
        CommonResponse<List<RoleResourceDto>> response = new CommonResponse<>();
        try {
            RoleResource resource = new RoleResource();
            resource.setRoleId(request.getId());
            List<RoleResource> resources = roleResourceMapper.selectList(new QueryWrapper<>(resource));
            List<RoleResourceDto> res = roleConverter.listRoleResource2Dto(resources);
            response.setData(res);
        } catch (Exception e) {
            log.error("RoleServiceImpl.listResource occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse updateBatchResource(UpdateRoleResourceRequest request) {
        log.info("RoleServiceImpl.updateBatchResource request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            RoleResource roleResource = roleConverter.reqRes2RoleResource(request);
            log.info("RoleServiceImpl.updateBatchResource 根据服务id，菜单id，角色id，删除原先的按钮信息");
            int row = roleResourceMapper.deleteByRoleIdServeIdMenuId(roleResource);
            log.info("RoleServiceImpl.updateBatchResource 删除的数据个数：" + row);
            // 批量删除之后，进行批量新增
            if (StringUtils.isNotEmpty(request.getElementId())){
                String[] elements = roleResource.getElementId().split(",");
                List<RoleResource> resources = new ArrayList<>(elements.length);
                for (String element : elements) {
                    resources.add(new RoleResource(
                            UUIDUtils.get32UUID(),
                            request.getRoleId(),
                            request.getServeId(),
                            request.getMenuId(),
                            element
                    ));
                }
                int insertRow = roleResourceMapper.insertBatch(resources);
                log.info("RoleServiceImpl.updateBatchResource  角色新绑定的数据量：" + insertRow);
            }
        } catch (Exception e) {
            log.error("RoleServiceImpl.updateBatchResource occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
