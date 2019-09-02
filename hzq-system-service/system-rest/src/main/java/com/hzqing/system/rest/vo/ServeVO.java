package com.hzqing.system.rest.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-13 21:33
 */
@Data
public class ServeVO implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务状态
     */
    private String status;

    /**
     * 权限标示
     */
    private String permission;

    /**
     * 创建人id
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
