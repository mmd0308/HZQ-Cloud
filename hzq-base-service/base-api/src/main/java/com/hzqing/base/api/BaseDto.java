package com.hzqing.base.api;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用的Dto实体类
 * @author hzqing
 * @date 2019-08-09 15:48
 */
@Data
public class BaseDto implements Serializable {
    private static final long serialVersionUID = -1489531753012274967L;

    /**
     * 创建人id
     */
    private Object createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private Object updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
