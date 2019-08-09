package com.hzqing.base.mapper;

import com.hzqing.base.entity.RoleServeMenuPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色,服务,菜单,资源关系 
角色只有拥有了服务,才能拥有菜单
只有拥有菜单,才能拥有资源 Mapper 接口
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface RoleServeMenuPermissionMapper extends BaseMapper<RoleServeMenuPermission> {

}
