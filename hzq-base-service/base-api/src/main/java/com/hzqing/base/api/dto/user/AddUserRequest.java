package com.hzqing.base.api.dto.user;

import com.hzqing.common.core.result.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class AddUserRequest extends AbstractRequest {

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
     * 注册邮箱
     */
    private String email;

    /**
     * 0 男 1 女
     */
    private String sex;

    /**
     * 请求参数进行校验
     */
    @Override
    public void checkParams() {
        // 如果教师失败，抛出异常
    }
}
