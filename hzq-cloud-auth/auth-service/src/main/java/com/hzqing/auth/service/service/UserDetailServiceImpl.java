package com.hzqing.auth.service.service;

import com.hzqing.base.api.dto.permission.GetUserRequest;
import com.hzqing.base.api.dto.permission.GetUserResponse;
import com.hzqing.base.api.dto.permission.PermissionDto;
import com.hzqing.base.api.service.IPermissionService;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-17 14:44
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Reference(version = GlobalConstants.VERSION_V1)
    IPermissionService permissionService;




    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("UserDetailServiceImpl.loadUserByUsername 请求用户名是: " + username);
        GetUserRequest request = new GetUserRequest();
        request.setUsername(username);
        GetUserResponse user = permissionService.getByUsername(request);
        log.info("UserDetailServiceImpl.loadUserByUsername 根据用户名获取数据结果：" +  user);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(user.getCode())){
            IDRequest idRequest = new IDRequest(user.getId());
            CommonResponse<List<PermissionDto>> commonResponse = permissionService.listPermissionByUserId(idRequest);
            List<PermissionDto> listPermissionDtos = commonResponse.getData();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>(listPermissionDtos.size());
            listPermissionDtos.forEach(permissionDto -> {
                GrantedAuthority authority = new SimpleGrantedAuthority(permissionDto.getPermission());
                grantedAuthorities.add(authority);
            });
            log.info("UserDetailServiceImpl.loadUserByUsername 该用户： " + user.getUsername() + " 拥有的权限： " + grantedAuthorities);
            return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        }
        log.error("UserDetailServiceImpl.loadUserByUsername 获取数据失败，返回null");
        return null;
    }
}
