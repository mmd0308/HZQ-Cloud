package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.permission.GetUserResponse;
import com.hzqing.system.provider.dal.entity.User;
import com.hzqing.system.api.dto.user.*;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    User req2User(AddUserRequest request);

    User req2User(UserListRequest request);

    /**
     * 将用户转换成dto
     * @param user
     * @return
     */
    UserDto user2Dto(User user);

    List<UserDto> users2List(List<User> users);

    User req2User(UserPageRequest request);

    User req2User(UpdateUserRequest request);

    Page<UserDto> pageUser2PageDto(IPage<User> userPage);

    GetUserResponse user2GetUser(User user);
}
