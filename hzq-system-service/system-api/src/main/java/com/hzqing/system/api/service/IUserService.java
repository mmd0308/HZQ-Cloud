package com.hzqing.system.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.system.api.dto.user.*;

import java.util.List;

/**
 * <p>
 * 用户服务接口
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface IUserService {

    /**
     * 创建用户
     * @param request
     * @return›
     */
    CommonResponse save(AddUserRequest request);

    /**
     * 根据id获取用户的信息
     * @param request
     * @return
     */
    CommonResponse<UserDto> getById(IDRequest request);


    /**
     * 根据条件获取用户分页列表
     * @param request
     * @return
     */
    CommonResponse<Page<UserDto>> page(UserPageRequest request);


    /**
     * 根据id删除用户
     * @param request
     * @return
     */
    CommonResponse removeById(IDRequest request);

    /**
     * 根据id，更新用户
     * @param request
     * @return
     */
    CommonResponse updateById(UpdateUserRequest request);

    /**
     * 根据角色id，获取分页用户信息
     * @param request
     * @return
     */
    CommonResponse<Page<UserDto>> pageByRoleId(UserRelationPageRequest request);

    /**
     * 根据角色id，获取有所的用户
     * @param request
     * @return
     */
    CommonResponse<List<UserDto>> listByRoleId(UserListByRoleIdRequest request);

    /**
     * 获取该角色id下面，不存在的用户分页信息
     * @param request
     * @return
     */
    CommonResponse<Page<UserDto>> pageNotByRoleId(UserRelationPageRequest request);

    /**
     * 根绝角色id，批量新增用户
     * @param request
     * @return
     */
    CommonResponse saveBatchUserRole(UserRoleRequest request);
}
