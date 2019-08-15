package com.hzqing.base.api.dto.button;

import com.hzqing.common.core.service.request.PageRequest;
import lombok.Data;
import lombok.ToString;

/**
 * @author hzqing
 * @date 2019-08-12 23:01
 */
@Data
@ToString(callSuper = true)
public class ElementPageRequest extends PageRequest {
    public ElementPageRequest() {
    }

    public ElementPageRequest(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }

}
