package com.hzqing.base.api.dto.menu;

import com.hzqing.common.core.service.request.PageRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-12 22:15
 */
@Data
public class MenuPageRequest extends PageRequest {
    private static final long serialVersionUID = 3824214447337982169L;

    public MenuPageRequest() {
    }

    public MenuPageRequest(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }
}
