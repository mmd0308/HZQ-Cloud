package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.role.*;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;

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
    CommonResponse save(AddRoleRequest request);

    /**
     * 根据id获取角色的信息
     * @param request
     * @return
     */
    CommonResponse<RoleDto> getById(IDRequest request);


    /**
     * 根据条件获取角色列表
     * @param request
     * @return
     */
    CommonResponse<List<RoleDto>> list(RoleListRequest request);

    /**
     * 根据条件删除角色
     * @param request
     * @return
     */
    CommonResponse removeById(IDRequest request);

    /**
     * 根据id，更新角色
     * @param request
     * @return
     */
    CommonResponse updateById(UpdateRoleRequest request);

    /**
     * 分页查询角色信息
     * @param request
     * @return
     */
    CommonResponse<Page<RoleDto>> page(RolePageRequest request);
}