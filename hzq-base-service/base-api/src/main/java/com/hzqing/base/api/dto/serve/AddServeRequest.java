package com.hzqing.base.api.dto.serve;

import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import com.hzqing.common.core.service.request.CheckIdRequest;
import lombok.Data;

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

    @Override
    public void checkParams() {
        if (name == null || name == "" || name.equals("")){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "服务名称不能为空！"
            );
        }
    }
}
