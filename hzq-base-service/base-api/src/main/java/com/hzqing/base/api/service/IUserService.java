package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.user.*;
import com.hzqing.common.core.service.response.CommonResponse;

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
    CommonResponse createUser(AddUserRequest request);

    /**
     * 根据条件获取用户的信息
     * @param request
     * @return
     */
    CommonResponse<UserDto> userDetail(UserDetailRequest request);


    /**
     * 根据条件获取用户分页列表
     * @param request
     * @return
     */
    CommonResponse<Page<UserDto>> userPage(UserPageRequest request);


    /**
     * 根据条件删除用户
     * @param request
     * @return
     */
    CommonResponse deleteUser(DeleteUserRequest request);

    /**
     * 根据id，更新用户
     * @param request
     * @return
     */
    CommonResponse updateUser(UpdateUserRequest request);

}
