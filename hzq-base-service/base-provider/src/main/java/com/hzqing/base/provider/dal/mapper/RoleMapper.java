package com.hzqing.base.provider.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzqing.base.provider.dal.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色管理表
 Mapper 接口
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectListByUserId(@Param("userId") String userId);
}
