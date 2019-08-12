package com.hzqing.base.rest.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-12 22:56
 */
public class RoleVO implements Serializable {
    private static final long serialVersionUID = 4347835058611314772L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 数据值
     */
    private String name;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记删除标记 ‘0’ 没有删除, ‘1’ 删除
     */
    private String delFlag;

    /**
     * 系统角色标记 ‘0’ 不是 ‘1’是
     */
    @ApiModelProperty(name = "sys_flag")
    private String sysFlag;

    /**
     * 创建人id
     */
    @ApiModelProperty(name = "create_by")
    private int createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private int updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
