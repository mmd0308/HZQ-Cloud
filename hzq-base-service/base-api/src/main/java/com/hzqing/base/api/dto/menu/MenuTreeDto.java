package com.hzqing.base.api.dto.menu;

import com.hzqing.common.core.service.dto.TreeNode;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-14 11:40
 */
@Data
public class MenuTreeDto extends TreeNode<MenuTreeDto> {

    /**
     * 菜单名称
     */
    private String name;

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
    private String showFlag;

    /**
     * 权限标示
     */
    private String permission;

    /**
     * 删除标记 0 否 1是
     */
    private String delFlag;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人id
     */
    private int createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private int updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
