package com.hzqing.base.api.service;

import com.hzqing.base.api.dto.permission.GetUserRequest;
import com.hzqing.base.api.dto.permission.GetUserResponse;
import com.hzqing.base.api.dto.permission.PermissionDto;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;

import java.util.List;

/**
 * 权限认证相关接口
 * @author hzqing
 * @date 2019-08-17 14:48
 */
public interface IPermissionService {

    /**
     * 根据用户名称查询用户
     * @param request
     * @return
     */
    GetUserResponse getByUsername(GetUserRequest request);

    /**
     * 根据用户id，获取用户拥有的所有的资源权限表示
     * @param request
     * @return
     */
    CommonResponse<List<PermissionDto>> listPermissionByUserId(IDRequest request);

}
