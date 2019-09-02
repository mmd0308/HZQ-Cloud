package com.hzqing.system.api.dto.serve;

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
public class UpdateServeRequest extends IDRequest {

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
     * 更新人id
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Override
    public void checkParams() {
        super.checkParams();
    }
}
