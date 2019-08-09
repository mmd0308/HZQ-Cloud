package com.hzqing.base.provider.service;

import com.hzqing.base.api.user.service.IUserService;
import com.hzqing.base.provider.entity.User;
import com.hzqing.base.provider.mapper.UserMapper;
import com.hzqing.common.provider.service.BaseServiceImpl;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author hzqing
 * @date 2019-08-09 14:57
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {


}
