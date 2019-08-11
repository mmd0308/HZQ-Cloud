package com.hzqing.base.api.dto.user;

import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:59
 */
@Data
public class DeleteUserRequest extends AbstractRequest {

    private int id;

    @Override
    public void checkParams() {

    }
}
