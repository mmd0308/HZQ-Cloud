package com.hzqing.system.api.dto.user;


import com.hzqing.common.core.service.request.PageRequest;
import lombok.Data;
import lombok.ToString;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
@ToString(callSuper = true)
public class UserPageRequest extends PageRequest {

    @Override
    public void checkParams() {
        super.checkParams();
    }
}
