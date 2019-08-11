package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzqing.base.api.dto.user.*;
import com.hzqing.base.api.service.IUserService;
import com.hzqing.base.provider.converter.UserConverter;
import com.hzqing.base.provider.dal.entity.User;
import com.hzqing.base.provider.dal.mapper.UserMapper;
import com.hzqing.common.core.exception.ExceptionProcessUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 14:57
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserConverter userConverter;

    @Override
    public AddUserResponse createUser(AddUserRequest request) {
        log.info("UserServiceImpl.createUser request: " + request);
        AddUserResponse response = new AddUserResponse();
        try {
            // 参数校验
            request.checkParams();
            User user = userConverter.req2User(request);
            int insert = userMapper.insert(user);
            log.info("UserServiceImpl.createUser effect row:  " + insert);
        }catch (Exception e) {
            // 抛出异常
            log.error("UserServiceImpl.createUser occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public UserDetailResponse userDetail(UserDetailRequest request) {
        log.info("UserServiceImpl.userDetail request: " + request);
        UserDetailResponse response = new UserDetailResponse();
        try {
            request.checkParams();
            User user = userMapper.selectById(request.getId());
            UserDto userDto = userConverter.user2Dto(user);
            response.setUserDto(userDto);
        }catch (Exception e){
            log.error("UserServiceImpl.userDetail occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public UserListResponse userLists(UserListRequest request) {
        log.info("UserServiceImpl.userLists request: " + request);
        UserListResponse response = new UserListResponse();
        try {
            request.checkParams();
            User user = userConverter.req2User(request);
            List users = userMapper.selectList(new QueryWrapper(user));
            response.setUserDtoList(userConverter.users2List(users));
        }catch (Exception e){
            log.error("UserServiceImpl.userLists occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        log.info("UserServiceImpl.deleteUser request: " + request);
        DeleteUserResponse response = new DeleteUserResponse();
        try {
            request.checkParams();
            int row = userMapper.deleteById(request.getId());
            log.info("UserServiceImpl.deleteUser effect: " + row);
        } catch (Exception e){
            log.error("UserServiceImpl.deleteUser occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
