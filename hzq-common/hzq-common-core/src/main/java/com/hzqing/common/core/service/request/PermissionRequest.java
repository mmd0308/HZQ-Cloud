package com.hzqing.common.core.service.request;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import lombok.Data;

/**
 * 权限表示校验，request
 * @author hzqing
 * @date 2019-09-02 14:19
 */
@Data
public class PermissionRequest extends AbstractRequest {

    /**
     * 权限编码
     */
    private String permission;

    /**
     * 主键id
     */
    private String id;


    public PermissionRequest(String permission, String id) {
        this.permission = permission;
        this.id = id;
    }

    @Override
    public void checkParams() {
        if (null == permission || permission.equals("")){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "权限编码不能唯空"
            );
        }
    }
}
