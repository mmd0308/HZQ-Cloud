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
 * 角色管理表

 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("base_role")
public class Role extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 数据值
     */
    private String name;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记删除标记 ‘0’ 没有删除, ‘1’ 删除
     */
    @TableField("del_flag")
    private String delFlag;

    /**
     * 系统角色标记 ‘0’ 不是 ‘1’是
     */
    @TableField("sys_flag")
    private String sysFlag;

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
