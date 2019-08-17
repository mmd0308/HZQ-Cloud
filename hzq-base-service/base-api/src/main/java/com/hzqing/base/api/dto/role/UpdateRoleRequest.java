package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.service.request.IDRequest;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-12 23:03
 */
@Data
@ToString(callSuper = true)
public class UpdateRoleRequest extends IDRequest {

    /**
     * 数据值
     */
    private String name;

    private String parentId;

    private String parentIds;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 系统角色标记 ‘0’ 不是 ‘1’是
     */
    private String sysFlag;

    /**
     * 更新人id
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
