package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 01:20
 */
@Data
public class RoleDto extends BaseDto {

    /**
     * 主键
     */
    private String id;

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
    private String sysFlag;

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


    private String parentId;

    private String parentIds;
}
