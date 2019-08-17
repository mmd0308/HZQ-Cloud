package com.hzqing.base.provider.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzqing.base.provider.dal.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    int insertBatch(List<UserRole> users);
}
