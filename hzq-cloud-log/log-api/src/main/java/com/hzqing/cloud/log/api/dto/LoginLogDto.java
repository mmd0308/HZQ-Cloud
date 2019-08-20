package com.hzqing.cloud.log.api.dto;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户登陆日志
 * </p>
 *
 * @author hzqing
 * @since 2019-08-19
 */

@Data
@Accessors(chain = true)
public class LoginLogDto extends BaseDto {

    private static final long serialVersionUID = 1L;


    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 登陆账号
     */
    private String loginName;

    /**
     * 登陆ip
     */
    private String ip;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 登陆时间
     */
    private LocalDateTime createTime;

}
