package com.hzqing.base.api.dto.user;

import com.hzqing.common.core.result.AbstractResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-10 00:57
 */
@Data
@ToString(callSuper = true)
public class UserListResponse extends AbstractResponse {

    private List<UserDto> userDtoList;

}
