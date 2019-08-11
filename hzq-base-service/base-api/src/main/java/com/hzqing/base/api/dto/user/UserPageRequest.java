package com.hzqing.base.api.dto.user;


import com.hzqing.common.core.service.request.PageRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
public class UserPageRequest extends PageRequest {

    @Override
    public void checkParams() {
        super.checkParams();
    }
}
