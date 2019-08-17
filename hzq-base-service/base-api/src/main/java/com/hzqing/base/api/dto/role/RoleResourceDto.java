package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-17 09:43
 */
@Data
public class RoleResourceDto extends BaseDto {


    private static final long serialVersionUID = 1870765059888124125L;

    private String roleId;

    private String serveId;

    private String menuId;

    private String elementId;

}
