package com.hzqing.system.api.dto.serve;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务管理表
 * </p>
 *
 * @author hzqing
 * @since 2019-08-13
 */

@Data
@Accessors(chain = true)
public class ServeDto extends BaseDto {

    private static final long serialVersionUID = 1L;


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
