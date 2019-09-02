package com.hzqing.system.api.dto.permission;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hzqing
 * @date 2019-08-17 14:50
 */
@Data
public class GetUserRequest extends AbstractRequest {

    private static final long serialVersionUID = -2785692247689861217L;
    /**
     * 用户名称
     */
    private String username;


    @Override
    public void checkParams() {
        if (StringUtils.isEmpty(username)) {
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "根据用户名获取用户信息，用户名称不能唯空"
            );
        }
    }
}
