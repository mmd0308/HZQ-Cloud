package com.hzqing.system.provider.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.permission.GetUserResponse;
import com.hzqing.system.api.dto.user.AddUserRequest;
import com.hzqing.system.api.dto.user.UpdateUserRequest;
import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.api.dto.user.UserListRequest;
import com.hzqing.system.api.dto.user.UserPageRequest;
import com.hzqing.system.provider.dal.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-02T15:45:24+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User req2User(AddUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setPhone( request.getPhone() );
        user.setEmail( request.getEmail() );
        user.setSex( request.getSex() );

        return user;
    }

    @Override
    public User req2User(UserListRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public UserDto user2Dto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhone( user.getPhone() );
        userDto.setEmail( user.getEmail() );
        userDto.setSex( user.getSex() );
        userDto.setCreateTime( user.getCreateTime() );
        userDto.setUpdateTime( user.getUpdateTime() );

        return userDto;
    }

    @Override
    public List<UserDto> users2List(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( user2Dto( user ) );
        }

        return list;
    }

    @Override
    public User req2User(UserPageRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public User req2User(UpdateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setId( request.getId() );
        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setPhone( request.getPhone() );
        user.setEmail( request.getEmail() );
        user.setSex( request.getSex() );
        user.setUpdateTime( request.getUpdateTime() );

        return user;
    }

    @Override
    public Page<UserDto> pageUser2PageDto(IPage<User> userPage) {
        if ( userPage == null ) {
            return null;
        }

        Page<UserDto> page = new Page<UserDto>();

        page.setPages( userPage.getPages() );
        page.setRecords( users2List( userPage.getRecords() ) );
        page.setTotal( userPage.getTotal() );
        page.setSize( userPage.getSize() );
        page.setCurrent( userPage.getCurrent() );
        page.setSearchCount( userPage.isSearchCount() );

        return page;
    }

    @Override
    public GetUserResponse user2GetUser(User user) {
        if ( user == null ) {
            return null;
        }

        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setId( user.getId() );
        getUserResponse.setUsername( user.getUsername() );
        getUserResponse.setPassword( user.getPassword() );

        return getUserResponse;
    }
}
