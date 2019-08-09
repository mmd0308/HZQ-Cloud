package com.hzqing.base.api.dto.user;

import com.hzqing.common.core.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
public class UserListResponse extends AbstractResponse {

    private List<UserDto> userDtoList;

}
