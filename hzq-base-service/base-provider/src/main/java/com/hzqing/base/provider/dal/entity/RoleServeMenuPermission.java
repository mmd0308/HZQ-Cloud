package com.hzqing.base.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.provider.dal.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色,服务,菜单,资源关系 
角色只有拥有了服务,才能拥有菜单
只有拥有菜单,才能拥有资源
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("base_role_serve_menu_permission")
public class RoleServeMenuPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 服务id
     */
    private Integer serveId;

    /**
     * 菜单id
     */
    private Integer menuId;

    /**
     * 资源id
     */
    private Integer permissionId;


}
