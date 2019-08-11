package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.result.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:59
 */
@Data
public class DeleteRoleRequest extends AbstractRequest {

    private int id;

    @Override
    public void checkParams() {

    }
}
