package com.hzqing.system.api.dto.user;

import com.hzqing.common.core.service.request.IDRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-12 21:35
 */
@Data
public class UpdateUserRequest extends IDRequest {

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

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Override
    public void checkParams() {
        super.checkParams();
    }
}
