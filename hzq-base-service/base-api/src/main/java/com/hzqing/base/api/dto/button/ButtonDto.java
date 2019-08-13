package com.hzqing.base.api.dto.button;

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
public class ButtonDto extends BaseDto {

    private static final long serialVersionUID = 1L;


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

    private Integer createBy;

    private LocalDateTime ceateTime;

    private Integer updateBy;

    private LocalDateTime updateTime;

}
