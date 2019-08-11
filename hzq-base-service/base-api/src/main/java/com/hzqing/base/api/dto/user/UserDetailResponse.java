package com.hzqing.base.api.dto.user;

import com.hzqing.common.core.result.AbstractResponse;
import lombok.Data;
import lombok.ToString;

/**
 * @author hzqing
 * @date 2019-08-10 00:39
 */
@Data
@ToString(callSuper = true)
public class UserDetailResponse extends AbstractResponse {

    private UserDto userDto;


}
