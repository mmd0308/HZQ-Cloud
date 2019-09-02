package com.hzqing.system.api.dto.button;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;
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
@Accessors(chain = true)
public class ElementDto extends BaseDto {

    private static final long serialVersionUID = 1L;


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
    /**
     * 元素类型 button，url等
     */
    private String elementType;
    /**
     * 请求方法，post，get,put等
     */
    private String method;

    private String description;

}
