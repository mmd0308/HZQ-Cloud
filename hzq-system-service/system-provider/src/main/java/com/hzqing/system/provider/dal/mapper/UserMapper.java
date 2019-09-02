package com.hzqing.system.provider.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.provider.dal.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 15:56
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据角色id，获取用户分页信息
     * @param userPage
     * @param roleId
     * @return
     */
    IPage<User> selectPageByRoleId(Page<User> userPage, @Param("roleId") String roleId);

    /**
     * 根据角色id，获取所有的用户信息
     * @param roleId
     * @return
     */
    List<User> selectListByRoleId(@Param("roleId") String roleId);

    /**
     * 获取该角色id下面不存的用户分页信息
     * @param userPage
     * @param roleId
     * @return
     */
    IPage<User> selectPageNotByRoleId(Page<User> userPage, @Param("roleId") String roleId);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    User selectByUserName(@Param("username") String username);
}
