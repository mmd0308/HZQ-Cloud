package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.user.AddUserRequest;
import com.hzqing.system.api.dto.user.UpdateUserRequest;
import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.rest.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    Page<UserVO> dto2Vo(Page<UserDto> data);

    AddUserRequest vo2Dto(UserVO userVO);

    UserVO dto2Vo(UserDto data);

    UpdateUserRequest vo2UpdateDto(UserVO userVO);
}
