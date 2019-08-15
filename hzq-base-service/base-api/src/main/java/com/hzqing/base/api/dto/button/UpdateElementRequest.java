package com.hzqing.base.api.dto.button;

import com.hzqing.common.core.service.request.IDRequest;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-12 23:03
 */
@Data
@ToString(callSuper = true)
public class UpdateElementRequest extends IDRequest {

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

    @Override
    public void checkParams() {
        super.checkParams();
    }
}
