package com.hzqing.log.provider.dal.entity;

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
 * 用户操作相关日志
 * </p>
 *
 * @author hzqing
 * @since 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("log_operation")
public class OperationLog extends BaseEntity {


    private static final long serialVersionUID = 3984606734053008716L;
    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
