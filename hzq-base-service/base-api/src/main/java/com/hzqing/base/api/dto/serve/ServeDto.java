package com.hzqing.base.api.dto.serve;

import com.hzqing.common.core.service.dto.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

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
    private Integer id;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务状态
     */
    private String status;

}
