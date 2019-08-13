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
@TableName("base_button")
public class Button extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *  自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单id,按钮属于哪个菜单下面的
     */
    private Integer menuId;

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
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    @TableField("update_by")
    private Integer updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}
