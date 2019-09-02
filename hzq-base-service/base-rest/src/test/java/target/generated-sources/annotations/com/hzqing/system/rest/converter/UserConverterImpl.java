package com.hzqing.system.rest.converter;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.user.AddUserRequest;
import com.hzqing.system.api.dto.user.UpdateUserRequest;
import com.hzqing.system.api.dto.user.UserDto;
import com.hzqing.system.rest.vo.UserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-02T16:15:38+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public Page<UserVO> dto2Vo(Page<UserDto> data) {
        if ( data == null ) {
            return null;
        }

        Page<UserVO> page = new Page<UserVO>();

        page.setPages( data.getPages() );
        page.setRecords( userDtoListToUserVOList( data.getRecords() ) );
        page.setTotal( data.getTotal() );
        page.setSize( data.getSize() );
        page.setCurrent( data.getCurrent() );
        List<OrderItem> list1 = data.getOrders();
        if ( list1 != null ) {
            page.setOrders( new ArrayList<OrderItem>( list1 ) );
        }
        page.setSearchCount( data.isSearchCount() );

        return page;
    }

    @Override
    public AddUserRequest vo2Dto(UserVO userVO) {
        if ( userVO == null ) {
            return null;
        }

        AddUserRequest addUserRequest = new AddUserRequest();

        addUserRequest.setUsername( userVO.getUsername() );
        addUserRequest.setPassword( userVO.getPassword() );
        addUserRequest.setPhone( userVO.getPhone() );
        addUserRequest.setEmail( userVO.getEmail() );
        addUserRequest.setSex( userVO.getSex() );

        return addUserRequest;
    }

    @Override
    public UserVO dto2Vo(UserDto data) {
        if ( data == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( data.getId() );
        userVO.setUsername( data.getUsername() );
        userVO.setPassword( data.getPassword() );
        userVO.setPhone( data.getPhone() );
        userVO.setEmail( data.getEmail() );
        userVO.setSex( data.getSex() );
        userVO.setCreateTime( data.getCreateTime() );
        userVO.setUpdateTime( data.getUpdateTime() );

        return userVO;
    }

    @Override
    public UpdateUserRequest vo2UpdateDto(UserVO userVO) {
        if ( userVO == null ) {
            return null;
        }

        UpdateUserRequest updateUserRequest = new UpdateUserRequest();

        updateUserRequest.setId( userVO.getId() );
        updateUserRequest.setUsername( userVO.getUsername() );
        updateUserRequest.setPassword( userVO.getPassword() );
        updateUserRequest.setPhone( userVO.getPhone() );
        updateUserRequest.setEmail( userVO.getEmail() );
        updateUserRequest.setSex( userVO.getSex() );
        updateUserRequest.setUpdateTime( userVO.getUpdateTime() );

        return updateUserRequest;
    }

    protected List<UserVO> userDtoListToUserVOList(List<UserDto> list) {
        if ( list == null ) {
            return null;
        }

        List<UserVO> list1 = new ArrayList<UserVO>( list.size() );
        for ( UserDto userDto : list ) {
            list1.add( dto2Vo( userDto ) );
        }

        return list1;
    }
}
