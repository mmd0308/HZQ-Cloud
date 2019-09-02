package com.hzqing.system.api.dto.permission;

import com.hzqing.common.core.service.response.AbstractResponse;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-17 14:51
 */
@Data
public class GetUserResponse extends AbstractResponse {

    private String id;

    private String username;

    private String password;
}
