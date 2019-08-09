package com.hzqing.base.api.service;

import com.hzqing.base.api.dto.user.*;

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
     * @return
     */
    AddUserResponse createUser(AddUserRequest request);

    /**
     * 根据条件获取用户的信息
     * @param request
     * @return
     */
    UserDetailResponse userDetail(UserDetailRequest request);


    /**
     * 根据条件获取用户列表
     * @param request
     * @return
     */
    UserListResponse userLists(UserListRequest request);

    /**
     * 根据条件删除用户
     * @param request
     * @return
     */
    DeleteUserResponse deleteUser(DeleteUserRequest request);
}
