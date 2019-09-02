package com.hzqing.system.api.dto.menu;

import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-14 10:45
 */
@Data
public class MenuTreeRequest extends AbstractRequest {

    private static final long serialVersionUID = -1609037018837103022L;

    private String serveId;


    @Override
    public void checkParams() {

    }
}
