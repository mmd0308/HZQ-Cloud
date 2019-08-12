package com.hzqing.base.rest.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单vo类
 * @author hzqing
 * @date 2019-08-12 21:59
 */
@Data
public class MenuVO implements Serializable {


    /**
     * 主键
     */
    private int id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 上级菜单id 顶级菜单父级id为0
     */
    @ApiModelProperty(name = "parent_id",notes = "顶级菜单的父级id是0")
    private int parentId;

    /**
     * 所有父级id,用“,”顺序分隔
     */
    private String parentIds;

    /**
     * 链接
     */
    private String href;

    /**
     * 图标名称
     */
    private String icon;

    /**
     * 是否在菜单显示 0 否 1 是 默认是1
     */
    @ApiModelProperty(name = "show_flag")
    private String showFlag;

    /**
     * 权限标示
     */
    private String permission;

    /**
     * 删除标记 0 否 1是
     */
    @ApiModelProperty(name = "del_flag")
    private String delFlag;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 排序
     */
    private int sort;

    /**
     * 创建人id
     */
    @ApiModelProperty(name = "create_by")
    private int createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    @ApiModelProperty(name = "update_by")
    private int updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(name = "update_time")
    private LocalDateTime updateTime;
}
