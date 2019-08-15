package com.hzqing.base.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.service.dal.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 按钮资源表
 * </p>
 *
 * @author hzqing
 * @since 2019-08-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("base_element")
public class Element extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *  自增主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 菜单id,按钮属于哪个菜单下面的
     */
    @TableField("menu_id")
    private String menuId;

    /**
     * 按钮名称
     */
    private String name;

    /**
     * 权限标示
     */
    private String permission;

    /**
     * 链接
     */
    private String href;

    /**
     * 创建人id
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 元素类型 button，url等
     */
    @TableField("element_type")
    private String elementType;

    /**
     * 请求方法，post，get,put等
     */
    private String method;

    /**
     * 描述
     */
    private String description;

}
