package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.user.AddUserRequest;
import com.hzqing.base.api.dto.user.UpdateUserRequest;
import com.hzqing.base.api.dto.user.UserDto;
import com.hzqing.base.api.dto.user.UserPageRequest;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;

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

}
