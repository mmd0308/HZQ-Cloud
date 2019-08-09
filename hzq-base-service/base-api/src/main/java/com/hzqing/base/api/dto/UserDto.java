package com.hzqing.base.api.dto;

import com.hzqing.base.api.BaseDto;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-09 15:48
 */
@Data
public class UserDto extends BaseDto {
    /**
     * 用户id
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
     * 注册邮箱
     */
    private String email;

    /**
     * 0 男 1 女
     */
    private String sex;

}
