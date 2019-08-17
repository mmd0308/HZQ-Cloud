package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import lombok.ToString;

/**
 * @author hzqing
 * @date 2019-08-16 07:59
 */
@Data
@ToString(callSuper = true)
public class RoleTreeRequest  extends AbstractRequest {

    @Override
    public void checkParams() {


    }
}
