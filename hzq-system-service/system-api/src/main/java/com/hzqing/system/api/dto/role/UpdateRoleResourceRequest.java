package com.hzqing.system.api.dto.role;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hzqing
 * @date 2019-08-17 12:49
 */
@Data
public class UpdateRoleResourceRequest extends AbstractRequest {
    private String roleId;

    private String serveId;

    private String menuId;

    private String elementId;

    @Override
    public void checkParams() {
        if (StringUtils.isEmpty(roleId) && StringUtils.isEmpty(serveId) && StringUtils.isEmpty(menuId)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    CommonRetCodeConstants.INVALID_PARAMETER.getMsg()
            );
        }
    }
}
