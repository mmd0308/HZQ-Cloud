package com.hzqing.system.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.system.api.dto.role.*;

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

    /**
     * 根据条件获取所有树行结果
     * @param request
     * @return
     */
    CommonResponse<List<RoleTreeDto>> tree(RoleTreeRequest request);

    /**
     * 给角色服务资源权限
     * @param request
     * @return
     */
    CommonResponse saveResource(AddRoleResourceRequest request);

    /**
     * 根绝角色id，获取所有的资源id
     * @param request
     * @return
     */
    CommonResponse<List<RoleResourceDto>> listResource(IDRequest request);

    /**
     * 根绝角色ID，服务id，菜单id，批量更新菜单
     * @param request
     * @return
     */
    CommonResponse updateBatchResource(UpdateRoleResourceRequest request);
}