package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.service.request.CheckIdRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:59
 */
@Data
public class DeleteRoleRequest extends CheckIdRequest {

    @Override
    public void checkParams() {

    }
}
