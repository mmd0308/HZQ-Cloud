package com.hzqing.base.api.dto.button;

import com.hzqing.base.api.constants.UserRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class AddButtonRequest extends AbstractRequest {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜单id,按钮属于哪个菜单下面的
     */
    private Integer menuId;

    /**
     * 按钮名称
     */
    private String name;

    /**
     * 权限标示
     */
    private String permission;

    /**
     * 链接
     */
    private String href;

    private Integer createBy;

    private LocalDateTime ceateTime;

    private Integer updateBy;

    private LocalDateTime updateTime;

    /**
     * 请求参数进行校验
     */
    @Override
    public void checkParams() {
        if (name == null || "".equals(name)){
            throw new ParamsValidateException(
                    UserRetCodeConstants.INVALID_PARAMETER.getCode(),
                    UserRetCodeConstants.INVALID_PARAMETER.getMsg());
        }
    }
}
