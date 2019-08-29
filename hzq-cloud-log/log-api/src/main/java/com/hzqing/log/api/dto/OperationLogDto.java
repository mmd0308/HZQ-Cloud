package com.hzqing.log.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import com.hzqing.common.core.service.dto.BaseDto;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户操作相关日志
 * </p>
 *
 * @author hzqing
 * @since 2019-08-19
 */

@Data
@Accessors(chain = true)
public class OperationLogDto extends BaseDto {

    private static final long serialVersionUID = 1L;


    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 操作人
     */
    private String loginName;

    /**
     * 请求的路径
     */
    private String url;

    /**
     * Ip地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 操作时间
     */
    private LocalDateTime createTime;

}
