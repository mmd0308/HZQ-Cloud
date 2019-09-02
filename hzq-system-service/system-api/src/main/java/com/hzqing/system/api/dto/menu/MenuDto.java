package com.hzqing.system.api.dto.menu;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 01:20
 */
@Data
public class MenuDto extends BaseDto {

    /**
     * 主键
     */
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 服务id
     */
    private Integer serveId;

    /**
     * 上级菜单id 顶级菜单父级id为0
     */
    private String parentId;

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
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人id
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
