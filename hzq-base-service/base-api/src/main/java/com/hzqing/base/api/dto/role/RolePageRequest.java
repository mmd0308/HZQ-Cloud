package com.hzqing.base.api.dto.role;

import com.hzqing.common.core.service.request.PageRequest;

/**
 * @author hzqing
 * @date 2019-08-12 23:01
 */
public class RolePageRequest extends PageRequest {
    public RolePageRequest() {
    }

    public RolePageRequest(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }
}
