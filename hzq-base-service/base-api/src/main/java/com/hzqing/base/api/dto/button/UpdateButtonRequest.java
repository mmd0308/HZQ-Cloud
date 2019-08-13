package com.hzqing.base.api.dto.button;

import com.hzqing.common.core.service.request.CheckIdRequest;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-12 23:03
 */
@Data
@ToString(callSuper = true)
public class UpdateButtonRequest extends CheckIdRequest {


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
