package com.hzqing.system.api.dto.role;

import com.hzqing.common.core.service.request.PageRequest;
import lombok.Data;
import lombok.ToString;

/**
 * @author hzqing
 * @date 2019-08-12 23:01
 */
@Data
@ToString(callSuper = true)
public class RolePageRequest extends PageRequest {
    public RolePageRequest() {
    }

    public RolePageRequest(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }

}
