package com.hzqing.system.api.dto.button;

import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
public class ElementListRequest extends AbstractRequest {


    private String menuId;

    @Override
    public void checkParams() {

    }
}
