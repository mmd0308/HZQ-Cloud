package com.hzqing.base.provider.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzqing.base.provider.dal.entity.RoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  角色和资源 Mapper 接口
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

    int deleteByRoleIdServeIdMenuId(RoleResource roleResource);

    int insertBatch(List<RoleResource> resources);

    List<RoleResource> selectBatchByRoleIds(@Param("roleIds") String roleIds);
}
