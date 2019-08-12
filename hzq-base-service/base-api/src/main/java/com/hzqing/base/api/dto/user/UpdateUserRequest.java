package com.hzqing.base.api.dto.user;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-12 21:35
 */
@Data
public class UpdateUserRequest extends AbstractRequest {

    /**
     * 主键
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱dd
     */
    private String email;

    /**
     * 0 男 1 女
     */
    private String sex;

    @Override
    public void checkParams() {
        if (id == 0){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    CommonRetCodeConstants.INVALID_PARAMETER.getMsg()
            );
        }
    }
}
