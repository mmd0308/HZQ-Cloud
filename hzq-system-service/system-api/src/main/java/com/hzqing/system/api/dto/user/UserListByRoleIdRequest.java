package com.hzqing.system.api.dto.user;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hzqing
 * @date 2019-08-16 15:38
 */
@Data
@ToString(callSuper = true)
public class UserListByRoleIdRequest extends AbstractRequest {

    private String roleId;

    public UserListByRoleIdRequest() {
    }

    public UserListByRoleIdRequest(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public void checkParams() {
        if (StringUtils.isEmpty(roleId)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "根绝角色id，获取用户信息，角色id不能唯空"
            );
        }
    }
}
