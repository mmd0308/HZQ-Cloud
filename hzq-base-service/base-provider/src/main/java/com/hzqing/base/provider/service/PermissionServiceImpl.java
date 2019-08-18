package com.hzqing.base.provider.service;

import com.hzqing.base.api.dto.permission.GetUserRequest;
import com.hzqing.base.api.dto.permission.GetUserResponse;
import com.hzqing.base.api.dto.permission.PermissionDto;
import com.hzqing.base.api.service.IPermissionService;
import com.hzqing.base.provider.converter.UserConverter;
import com.hzqing.base.provider.dal.entity.*;
import com.hzqing.base.provider.dal.mapper.*;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 用户权限相关接口实现类
 * @author hzqing
 * @date 2019-08-17 14:54
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V1)
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserConverter userConverter;

    @Override
    public GetUserResponse getByUsername(GetUserRequest request) {
        log.info("PermissionServiceImpl.getByUsername request: " + request);
        GetUserResponse response = new GetUserResponse();
        try {
            request.checkParams();
            User user = userMapper.selectByUserName(request.getUsername());
            response = userConverter.user2GetUser(user);
        }catch (Exception e) {
            log.error("PermissionServiceImpl.getByUsername occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private ServeMapper serveMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ElementMapper elementMapper;
    @Override
    public CommonResponse<List<PermissionDto>> listPermissionByUserId(IDRequest request) {
        log.info("PermissionServiceImpl.listPermissionByUserId request: " + request);
        CommonResponse<List<PermissionDto>> response = new CommonResponse<>();
        try {
            List<PermissionDto> permissionDtoList = new ArrayList<>();

            // 根据用户id，获取角色
            List<Role> roles = roleMapper.selectListByUserId(request.getId());

            StringBuilder builder = new StringBuilder();
            roles.forEach(role -> {
                builder.append(role.getId());
                builder.append(",");
            });
            String roleIds = builder.toString().substring(0,builder.toString().length()-1);
            log.info("PermissionServiceImpl.listPermissionByUserId 根据所有的角色id，获取所有的资源id：" + roleIds);
            List<RoleResource> resources = roleResourceMapper.selectBatchByRoleIds(roleIds);

            // 该用户用户的所有服务id
            List<String> serveIds = new ArrayList<>(resources.size());
            // 该用户拥有的所有菜单id
            List<String> menuIds = new ArrayList<>(resources.size());
            // 该用户拥有的所有按钮等资源id
            List<String> elementIds = new ArrayList<>(resources.size());
            resources.forEach(resource -> {
                serveIds.add(resource.getServeId());
                menuIds.add(resource.getMenuId());
                elementIds.add(resource.getElementId());
            });

            // 根据服务id，批量获取获取所有的服务
            log.info("PermissionServiceImpl.listPermissionByUserId 根据服务id，获取服务：服务id是：" + serveIds);
            if (serveIds.size() != 0){
                List<Serve> serves = serveMapper.selectBatchIds(serveIds);
            }

            // 根据id，获取所有的菜单
            log.info("PermissionServiceImpl.listPermissionByUserId 根据菜单id，获取该用户用户的所有的菜单,菜单id是：" + menuIds);
            if (menuIds.size() != 0){
                List<Menu> menus = menuMapper.selectBatchIds(menuIds);
                menus.forEach(menu -> {
                    permissionDtoList.add(new PermissionDto(menu.getPermission()));
                });
            }

            // 根据id，获取所有的按钮资源
            log.info("PermissionServiceImpl.listPermissionByUserId 根据元素id，获取所有的元素,元素id是：" + elementIds);
            if (elementIds.size() != 0) {
                List<Element> elements = elementMapper.selectBatchIds(elementIds);
                elements.forEach(element -> {
                    permissionDtoList.add(new PermissionDto(element.getPermission()));
                });
            }
            log.info("PermissionServiceImpl.listPermissionByUserId 返回的权限编码是：" + permissionDtoList);
            response.setData(permissionDtoList);
        }catch (Exception e) {
            log.error("PermissionServiceImpl.listPermissionByUserId occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
