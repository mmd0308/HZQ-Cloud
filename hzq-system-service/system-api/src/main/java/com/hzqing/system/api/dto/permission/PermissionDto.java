package com.hzqing.system.api.dto.permission;

import com.hzqing.common.core.service.response.AbstractResponse;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-18 08:47
 */
@Data
public class PermissionDto extends AbstractResponse {
    private static final long serialVersionUID = -512669432192545627L;

    /**
     * 权限编码，包括菜单，服务，按钮等资源
     */
    private String permission;


    public PermissionDto() {
    }

    public PermissionDto(String permission) {
        this.permission = permission;
    }
}
