package com.hzqing.base.provider.service.v2;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.user.*;
import com.hzqing.base.api.service.IUserService;
import com.hzqing.base.provider.dal.mapper.UserMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hzqing
 * @date 2019-08-09 14:57
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V2)
public class UserServiceImplV2 implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public CommonResponse createUser(AddUserRequest request) {
        return null;
    }

    @Override
    public CommonResponse<UserDto> userDetail(UserDetailRequest request) {
        return null;
    }

    @Override
    public CommonResponse<Page<UserDto>> userPage(UserPageRequest request) {
        return null;
    }

    @Override
    public CommonResponse deleteUser(DeleteUserRequest request) {
        return null;
    }

    @Override
    public CommonResponse updateUser(UpdateUserRequest request) {
        return null;
    }
}
