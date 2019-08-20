package com.hzqing.cloud.log.provider.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.hzqing.common.core.service.dal.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户登陆日志
 * </p>
 *
 * @author hzqing
 * @since 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("log_login")
public class LoginLog extends BaseEntity {


    private static final long serialVersionUID = 4016741173370172060L;
    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
