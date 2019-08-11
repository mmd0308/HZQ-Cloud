package com.hzqing.base.provider.converter;

import com.hzqing.base.api.dto.user.AddUserRequest;
import com.hzqing.base.api.dto.user.DeleteUserRequest;
import com.hzqing.base.api.dto.user.UserDto;
import com.hzqing.base.api.dto.user.UserListRequest;
import com.hzqing.base.provider.dal.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 17:04
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

//    @Mappings({})
    User req2User(AddUserRequest request);

    User req2User(UserListRequest request);

    /**
     * 将用户转换成dto
     * @param user
     * @return
     */
    UserDto user2Dto(User user);

    List<UserDto> users2List(List<User> users);

    User req2User(DeleteUserRequest request);
}
