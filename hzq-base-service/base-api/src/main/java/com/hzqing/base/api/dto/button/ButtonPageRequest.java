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
public class ButtonPageRequest extends PageRequest {
    public ButtonPageRequest() {
    }

    public ButtonPageRequest(int pageNum, int pageSize) {
        super(pageNum, pageSize);
    }

}
