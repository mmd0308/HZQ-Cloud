package com.hzqing.base.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.service.dal.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @author hzqing
 * @date 2019-08-17 09:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("rl_role_resource")
public class RoleResource extends BaseEntity {

    public RoleResource() {
    }
    public RoleResource(String roleId, String serveId, String menuId, String elementId) {
        this.roleId = roleId;
        this.serveId = serveId;
        this.menuId = menuId;
        this.elementId = elementId;
    }
    public RoleResource(String id,String roleId, String serveId, String menuId, String elementId) {
        this.id = id;
        this.roleId = roleId;
        this.serveId = serveId;
        this.menuId = menuId;
        this.elementId = elementId;
    }

    @TableId(type = IdType.UUID)
    private String id;

    @TableField("role_id")
    private String roleId;

    @TableField("serve_id")
    private String serveId;

    @TableField("menu_id")
    private String menuId;

    @TableField("element_id")
    private String elementId;

}
