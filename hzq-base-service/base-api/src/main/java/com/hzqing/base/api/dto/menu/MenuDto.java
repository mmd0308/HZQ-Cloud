package com.hzqing.base.api.dto.menu;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 01:20
 */
@Data
public class MenuDto extends BaseDto {

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
