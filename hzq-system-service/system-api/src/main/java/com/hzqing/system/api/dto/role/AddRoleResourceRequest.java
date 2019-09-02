package com.hzqing.system.api.dto.role;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hzqing
 * @date 2019-08-17 09:43
 */
@Data
public class AddRoleResourceRequest extends AbstractRequest {


    private static final long serialVersionUID = 1870765059888124125L;
    private String roleId;

    private String serveId;

    private String menuId;

    private String elementId;

    @Override
    public void checkParams() {
        if (StringUtils.isEmpty(roleId)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "角色和资源绑定，角色id不能唯恐!"
            );
        }
        if (StringUtils.isEmpty(serveId) && StringUtils.isEmpty(menuId) && StringUtils.isEmpty(elementId)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "角色和资源绑定，资源id不能唯空"
            );
        }
    }
}
