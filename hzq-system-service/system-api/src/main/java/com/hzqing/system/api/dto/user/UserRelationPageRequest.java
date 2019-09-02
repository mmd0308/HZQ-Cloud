package com.hzqing.system.api.dto.user;


import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.PageRequest;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
@ToString(callSuper = true)
public class UserRelationPageRequest extends PageRequest {


    private String roleId;

    public UserRelationPageRequest() {
    }

    public UserRelationPageRequest(int pageNum, int pageSize, String roleId) {
        super(pageNum, pageSize);
        this.roleId = roleId;
    }

    public UserRelationPageRequest(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public void checkParams() {
        super.checkParams();

        if (StringUtils.isEmpty(roleId)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "根绝角色id，获取用户信息，角色id不能唯空"
            );
        }
    }
}
