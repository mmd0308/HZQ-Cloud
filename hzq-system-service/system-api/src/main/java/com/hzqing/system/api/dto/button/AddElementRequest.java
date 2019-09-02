package com.hzqing.system.api.dto.button;

import com.hzqing.system.api.constants.UserRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class AddElementRequest extends AbstractRequest {



    /**
     * 菜单id,按钮属于哪个菜单下面的
     */
    private String menuId;

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

    private String createBy;

    private LocalDateTime ceateTime;

    private String updateBy;

    private LocalDateTime updateTime;
    /**
     * 元素类型 button，url等
     */
    private String elementType;
    /**
     * 请求方法，post，get,put等
     */
    private String method;

    private String description;

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
