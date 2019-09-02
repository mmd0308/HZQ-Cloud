package com.hzqing.system.api.dto.serve;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class AddServeRequest extends AbstractRequest {

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


    @Override
    public void checkParams() {
        if (StringUtils.isAnyEmpty(name,permission)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "服务名称不能为空！权限编码不能唯空"
            );
        }
    }
}
