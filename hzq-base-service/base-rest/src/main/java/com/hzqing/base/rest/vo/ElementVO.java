package com.hzqing.base.rest.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-13 21:36
 */
@Data
public class ElementVO implements Serializable {

    private static final long serialVersionUID = -8983925217800750512L;

    private String id;

    /**
     * 菜单id,按钮属于哪个菜单下面的
     */
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

    private String createBy;

    private LocalDateTime ceateTime;

    private String updateBy;

    private LocalDateTime updateTime;

}
