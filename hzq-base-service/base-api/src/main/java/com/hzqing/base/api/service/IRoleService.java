package com.hzqing.base.api.service;

import com.hzqing.base.api.dto.role.*;
import com.hzqing.base.api.dto.user.*;
import com.hzqing.common.core.result.CommonResponse;

import java.util.List;

/**
 * <p>
 * 角色管理表
 服务类
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface IRoleService  {
    /**
     * 创建角色
     * @param request
     * @return
     */
    CommonResponse createRole(AddRoleRequest request);

    /**
     * 根据条件获取角色的信息
     * @param request
     * @return
     */
    CommonResponse<RoleDto> roleDetail(RoleDetailRequest request);


    /**
     * 根据条件获取角色列表
     * @param request
     * @return
     */
    CommonResponse<List<RoleDto>> roleLists(RoleListRequest request);

    /**
     * 根据条件删除角色
     * @param request
     * @return
     */
    CommonResponse deleteRole(DeleteUserRequest request);
}